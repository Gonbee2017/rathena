// [GonBee]
// パーティーBOT機能のテンプレートな関数を定義する。

#ifndef PYBOT_TEMPLATE_HPP
#define PYBOT_TEMPLATE_HPP

namespace pybot {

// -----------------------------------------------------------------------------
// レジストリ型のメンバー関数の定義

// レジストリを構築する。
template <class K, class T>
registry_t<K,T>::registry_t(
	load_func loa, // ロード。
	save_func ins, // 挿入。
	save_func upd, // 更新。
	save_func del  // 削除。
) {
	sav_funs[RD_INSERT - RD_INSERT] = ins;
	sav_funs[RD_UPDATE - RD_INSERT] = upd;
	sav_funs[RD_DELETE - RD_INSERT] = del;
	loading = true;
	sql_session::open([this, loa] (sql_session* ses) {
		loa(ses, this);
	});
	loading = false;
}

// レジストリを破棄する。
template <class K, class T>
registry_t<K,T>::~registry_t() {
	try {
		sql_session::open([this] (sql_session* ses) {
			for (auto wra_val : wras) {
				K key = wra_val.first;
				auto wra = wra_val.second;
				if (wra->dirty != RD_CLEAN) {
					save_func fun = sav_funs[wra->dirty - RD_INSERT];
					if (fun) fun(ses, key, wra->data.get());
				}
			}
		});
	} catch (const std::runtime_error&) {}
}

// レジストリをクリアする。
template <class K, class T>
int // 抹消した値の数。
registry_t<K,T>::clear() {
	int cou = 0;
	for (auto wra_val_ite = wras.begin(); wra_val_ite != wras.end();) {
		auto wra = wra_val_ite->second;
		if (wra->dirty == RD_DELETE) continue;
		if (wra->dirty == RD_INSERT) wras.erase(wra_val_ite++);
		else {
			if (wra->dirty == RD_CLEAN ||
				wra->dirty == RD_UPDATE
			) wra->dirty = RD_DELETE;
			++wra_val_ite;
		}
		++cou;
	}
	return cou;
}

// レジストリの値をコンテナにコピーする。
template <class K, class T>
template <
	class O // キーとデータのペアの出力反復子の型。
> void registry_t<K,T>::copy(
	O out // キーとデータのペアの出力反復子。
) {
	iterate([&out] (K key, T* dat) -> bool {
		*out++ = std::make_pair(key, dat);
		return true;
	});
}

// レジストリからキーを探す。
template <class K, class T>
T* // 見つけたデータ。見つからなかったらnullptr。
registry_t<K,T>::find(
	K key // キー。
) {
	auto wra = find_map_data(wras, key);
	if (!wra ||
		wra->dirty == RD_DELETE
	) return nullptr;
	return wra->data.get();
}

// 他のレジストリから値を取り込む。
template <class K, class T>
int // 取り込んだ数。
registry_t<K,T>::import_(
	registry_t* ano_reg // 他のレジストリ。
) {
	int cou = 0;
	ano_reg->iterate([this, &cou] (K key, T* dat) -> bool {
		if (!find(key)) {
			register_(key, construct<T>(*dat));
			++cou;
		}
		return true;
	});
	return cou;
}

// レジストリの値を反復する。
template <class K, class T>
void registry_t<K,T>::iterate(
	yield_func yie // 獲得。
) {
	for (auto wra_val : wras) {
		K key = wra_val.first;
		auto wra = wra_val.second;
		if (wra->dirty != RD_DELETE &&
			!yie(key, wra->data.get())
		) break;
	}
}

// レジストリに値を登録する。
template <class K, class T>
void registry_t<K,T>::register_(
	K key,     // キー。
	ptr<T> dat // データ。
) {
	auto wra = find_map_data(wras, key);
	if (!wra) {
		registry_dirties dir;
		if (loading) dir = RD_CLEAN;
		else dir = RD_INSERT;
		wras[key] = initialize<wrapper>(dir, dat);
	} else {
		wra->data = dat;
		if (wra->dirty == RD_CLEAN ||
			wra->dirty == RD_DELETE
		) wra->dirty = RD_UPDATE;
	}
}

// レジストリから値を抹消する。
template <class K, class T>
void registry_t<K,T>::unregister(
	K key // キー。
) {
	auto wra_val_ite = wras.find(key);
	if (wra_val_ite == wras.end()) return;
	auto wra = wra_val_ite->second;
	if (wra->dirty == RD_INSERT) wras.erase(wra_val_ite);
	else if (wra->dirty == RD_CLEAN ||
		wra->dirty == RD_UPDATE
	) wra->dirty = RD_DELETE;
}

// データなしレジストリを構築する。
template <class K>
registry_t<K,void>::registry_t(
	load_func loa, // ロード。
	save_func ins, // 挿入。
	save_func del  // 削除。
) {
	sav_funs[RD_INSERT - RD_INSERT] = ins;
	sav_funs[RD_DELETE - RD_INSERT] = del;
	loading = true;
	sql_session::open([this, loa] (sql_session* ses) {
		loa(ses, this);
	});
	loading = false;
}

// データなしレジストリを破棄する。
template <class K>
registry_t<K,void>::~registry_t() {
	try {
		sql_session::open([this] (sql_session* ses) {
			for (auto dir_val : dirs) {
				K key = dir_val.first;
				auto dir = dir_val.second;
				if (*dir != RD_CLEAN) {
					save_func fun = sav_funs[*dir - RD_INSERT];
					if (fun) fun(ses, key);
				}
			}
		});
	} catch (const std::runtime_error&) {}
}

// データなしレジストリをクリアする。
template <class K>
int // 抹消したキーの数。
registry_t<K,void>::clear() {
	int cou = 0;
	for (auto dir_val_ite = dirs.begin(); dir_val_ite != dirs.end();) {
		auto dir = dir_val_ite->second;
		if (*dir == RD_DELETE) continue;
		if (*dir == RD_INSERT) dirs.erase(dir_val_ite++);
		else if (*dir == RD_CLEAN) {
			*dir = RD_DELETE;
			++dir_val_ite;
		}
		++cou;
	}
	return cou;
}

// データなしレジストリのキーをコピーする。
template <class K>
template <
	class O // キーの出力反復子の型。
> void registry_t<K,void>::copy(
	O out // キーの出力反復子。
) {
	iterate([&out] (K key) -> bool {
		*out++ = key;
		return true;
	});
}

// データなしレジストリからキーを探す。
template <class K>
bool // 見つかったか。
registry_t<K,void>::find(
	K key // キー。
) {
	auto dir = find_map_data(dirs, key);
	if (!dir) return false;
	return *dir != RD_DELETE;
}

// 他のレジストリからキーを取り込む。
template <class K>
int // 取り込んだ数。
registry_t<K,void>::import_(
	registry_t* ano_reg // 他のレジストリ。
) {
	int cou = 0;
	ano_reg->iterate([this, &cou] (K key) -> bool {
		if (!find(key)) {
			register_(key);
			++cou;
		}
		return true;
	});
	return cou;
}

// データなしレジストリのキーを反復する。
template <class K>
void registry_t<K,void>::iterate(
	yield_func yie // 獲得。
) {
	for (auto dir_val : dirs) {
		K key = dir_val.first;
		auto dir = dir_val.second;
		if (*dir != RD_DELETE &&
			!yie(key)
		) break;
	}
}

// データなしレジストリにキーを登録する。
template <class K>
void registry_t<K,void>::register_(
	K key // キー。
) {
	auto dir = find_map_data(dirs, key);
	if (!dir) {
		dir = initialize<registry_dirties>();
		if (loading) *dir = RD_CLEAN;
		else *dir = RD_INSERT;
		dirs[key] = dir;
	} else if (*dir == RD_DELETE) *dir = RD_CLEAN;
}

// データなしレジストリからキーを抹消する。
template <class K>
void registry_t<K,void>::unregister(
	K key // キー。
) {
	auto dir_val_ite = dirs.find(key);
	if (dir_val_ite == dirs.end()) return;
	auto dir = dir_val_ite->second;
	if (*dir == RD_INSERT) dirs.erase(dir_val_ite);
	else if (*dir == RD_CLEAN) *dir = RD_DELETE;
}

// 登録値を構築する。
template <class T>
regnum_t<T>::regnum_t(
	map_session_data* sd_,  // セッションデータ。
	const std::string& key_ // キー。
) : sd(sd_), key(key_) {
	cache = T(pc_readreg2(sd, key.c_str()));
}

// 登録値から数値を取得する。
template <class T>
T // 取得した数値。
regnum_t<T>::get() {
	return cache;
}

// 登録値に数値を設定する。
template <class T>
void regnum_t<T>::set(
	T num // 数値。
) {
	cache = num;
	pc_setreg2(sd, key.c_str(), int(cache));
}

// ポリシーを構築する。
template <class V>
policy_t<V>::policy_t(
	int16_t mid, // モンスターID。
	V val        // 値。
) : mob_id(mid),
	individual_mob_id(0),
	mdb(nullptr),
	value(val)
{
	if (mob_id >= MM_INDIVIDUAL) {
		individual_mob_id = mob_id;
		if (individual_mob_id >= MM_CAUTION) individual_mob_id -= MM_CAUTION;
	}
	if (individual_mob_id) {
		mdb = mob_db(individual_mob_id);
		if (!mdb) RAISE_RUNTIME_ERROR("Invalid mob id.");
	}
}

// -----------------------------------------------------------------------------
// テンプレート関数の定義

// ブロックを探す。
template <
	class T // 探すブロックの型。
> block_if* // 見つかったブロック。見つからなかったらnullptr。
ai_t::find_block(
	int id // ID。
) {
	return dynamic_cast<T*>(find_map_data(blocks, id));
}

// SQL文を実行する。
template <
	class ...A // 一連の引数の型。
> void sql_session::execute(
	A&& ...args // 一連の引数。
) {
	sql_context con;
	con.append(args...);
	if (SqlStmt_Prepare(stmt, con.buffer.str().c_str()) == SQL_ERROR)
		RAISE_RUNTIME_ERROR("Failed SqlStmt_Prepare.");
	for (int i = 0; i < con.params.size(); ++i) con.params[i]->bind(stmt, i);
	if (SqlStmt_Execute(stmt) == SQL_ERROR)
		RAISE_RUNTIME_ERROR("Failed SqlStmt_Execute.");
	for (int i = 0; i < con.columns.size(); ++i) con.columns[i]->bind(stmt, i);
}

// SQLの文脈に一連の引数を追加する。
template <
	class ...A // 一連の引数の型。
> void sql_context::append(
	A&& ...args // 一連の引数。
) {
	append_with(args...);
}

// SQLの文脈にテキストと一連の引数を追加する。
template <
	class ...A // 一連の引数の型。
> void sql_context::append_with(
	const std::string& tex, // テキスト。
	A&& ...args             // 一連の引数。
) {
	append_with(tex);
	append_with(args...);
}

// SQLの文脈に列と一連の引数を追加する。
template <
	class ...A // 一連の引数の型。
> void sql_context::append_with(
	ptr<sql_column> col, // 列。
	A&& ...args          // 一連の引数。
) {
	append_with(col);
	append_with(args...);
}

// SQLの文脈にパラメータと一連の引数を追加する。
template <
	class ...A // 一連の引数の型。
> void sql_context::append_with(
	ptr<sql_param> par, // パラメータ。
	A&& ...args         // 一連の引数。
) {
	append_with(par);
	append_with(args...);
}

// SQL文にバインドするものを構築する。
template <
	class T // データの型。
> sql_binder::sql_binder(
	T& dat,    // データ。
	size_t siz // サイズ。
) {
	auto sdt_ite = SQL_DATA_TYPES.find(std::type_index(typeid(T)));
	if (sdt_ite == SQL_DATA_TYPES.end()) {
		if (std::is_array<T>::value) type = SQLDT_STRING;
		else RAISE_RUNTIME_ERROR("Invalid SQL data type.");
	} else type = sdt_ite->second;
	size = siz;
	if (std::is_pointer<T>::value) {
		data = (void*)(dat);
		if (!size) size = std::strlen((const char*)(dat));
	} else {
		data = (void*)(&dat);
		if (!size) size = sizeof(dat);
	}
}

// SQLの列を構築する。
template <
	class T // データの型。
> sql_column::sql_column(
	const std::string& nam, // 列名。
	T& dat,                 // データ。
	size_t siz              // サイズ。
) : sql_binder(dat, siz), name(nam) {}

// 末尾挿入反復子を構築する。
template <
	class C // コンテナの型。
> pybot::back_insert_iterator<C> back_inserter(
	C& x // コンテナ。
) {
	return pybot::back_insert_iterator<C>(x);
}

// 挿入反復子を構築する。
template <
	class C // コンテナの型。
> pybot::insert_iterator<C> inserter(
	C& x,                  // コンテナ。
	typename C::iterator i // ヒント。
) {
	return pybot::insert_iterator<C>(x, i);
}

// コマンド要素からブロックを集める。
template <
	class C, // 集めたブロックの型。
	class I  // 要素の入力反復子の型。
> ptr<C> // 集めたブロック。
command_collect_blocks(
    I ele_fir,              // 最初の要素の入力反復子。
	I ele_las,              // 最後の要素の入力反復子。
    const std::string& ope, // 開く記号。
    const std::string& clo, // 閉じる記号。
    bool all_emp            // 空っぽのブロックを許すか。
) {
	auto blos = initialize<C>();
	command_collect_blocks(ele_fir, ele_las, pybot::back_inserter(*blos), ope, clo, all_emp);
	return blos;
}

// コマンド要素からブロックを集める。
template <
	class I, // 要素の入力反復子の型。
	class O  // ブロックの出力反復子の型。
> void command_collect_blocks(
    I ele_fir,              // 最初の要素の入力反復子。
	I ele_las,              // 最後の要素の入力反復子。
    O blo_out,              // ブロックの出力反復子。
    const std::string& ope, // 開く記号。
    const std::string& clo, // 閉じる記号。
    bool all_emp            // 空っぽのブロックを許すか。
) {
	using blo_t = typename O::container::value_type::element_type;
    int fra = 0;
    bool ins = false;
	auto blo = initialize<blo_t>();
    auto flu = [blo_out, all_emp, &blo] () mutable {
        if (!all_emp &&
			(blo->empty() ||
				(blo->size() == 1 &&
					blo->front()->type == CET_LITERAL &&
					blo->front()->text.empty()
				)
			)
        ) return;
        *blo_out++ = blo;
		blo = initialize<blo_t>();
    };
    for (auto ele_ite = ele_fir; ele_ite != ele_las;) {
        auto ele = *ele_ite++;
        if (fra ||
            !((!ins &&
                    ele->type == CET_OPEN &&
                    ele->text == ope
                ) || (ins &&
                    ele->type == CET_CLOSE &&
                    ele->text == clo
                )
            )
        ) {
            if (ele->type == CET_OPEN) ++fra;
            else if (ele->type == CET_CLOSE) --fra;
            if (ins) blo->push_back(ele);
            continue;
        }
        if (ins) flu();
        ins = !ins;
    }
}

// コマンド要素からトークンを集める。
template <
	class C, // 集めたトークンの型。
	class I  // 要素の入力反復子の型。
> ptr<C> // 集めたトークン。
command_collect_tokens(
    I ele_fir,              // 最初の要素の入力反復子。
	I ele_las,              // 最後の要素の入力反復子。
    const std::string& sep, // 区切る記号。
    bool all_emp            // 空っぽのトークンを許すか。
) {
	auto toks = initialize<C>();
	command_collect_tokens(ele_fir, ele_las, pybot::back_inserter(*toks), sep, all_emp);
	return toks;
}

// コマンド要素からトークンを集める。
template <
    class I, // 要素の入力反復子の型。
    class O  // トークンの出力反復子の型。
> void command_collect_tokens(
    I ele_fir,              // 最初の要素の入力反復子。
    I ele_las,              // 最後の要素の入力反復子。
    O tok_out,              // トークンの出力反復子。
    const std::string& sep, // 区切る記号。
    bool all_emp            // 空っぽのトークンを許すか。
) {
    using tok_t = typename O::container::value_type::element_type;
    int fra = 0;
    auto tok = initialize<tok_t>();
    auto flu = [tok_out, all_emp, &tok] () mutable {
        if (all_emp ||
            (!tok->empty() &&
                (tok->size() > 1 ||
                    tok->front()->type != CET_LITERAL ||
                    !tok->front()->text.empty()
                )
            )
        ) {
            *tok_out++ = tok;
            tok = initialize<tok_t>();
        }
    };
    for (auto ele_ite = ele_fir; ele_ite != ele_las;) {
        auto ele = *ele_ite++;
        if (!fra &&
            ele->type == CET_SEPARATOR &&
            ele->text == sep
        ) flu();
        else {
            if (ele->type == CET_OPEN) ++fra;
            else if (ele->type == CET_CLOSE) --fra;
            tok->push_back(ele);
        }
    }
    flu();
}

// コマンドの引数を解析する。
template <
	class C // 解析した引数を格納したコンテナの型。
> ptr<C> // 解析した引数を格納したコンテナ。
command_parse_arguments(
	const std::string com // コマンド。
) {
	auto args = initialize<C>();
	command_parse_arguments(com, pybot::back_inserter(*args));
	return args;
}

// コマンドの引数を解析する。
template <
	class O // 引数の出力反復子の型。
> void command_parse_arguments(
	const std::string com, // コマンド。
	O arg_out              // 引数の出力反復子。
) {
	using ele_lis = std::list<ptr<command_element>>;
	using ele_lis_lis = std::list<ptr<ele_lis>>;
	auto eles = initialize<ele_lis>(initialize<command_element>(CET_LITERAL, com));
	eles = command_parse_blocks<ele_lis>(ALL_RANGE(*eles), "\"", "\"", false, true);
	eles = command_parse_tokens<ele_lis>(ALL_RANGE(*eles), " ", false, true);
	auto toks = command_collect_tokens<ele_lis_lis>(ALL_RANGE(*eles), " ", false);
	for (auto tok : *toks) tok->remove_if(
		[] (const ptr<command_element>& ele) -> bool
		{return ele->type == CET_OPEN || ele->type == CET_CLOSE;}
	);
	command_print_all(ALL_RANGE(*toks), arg_out);
}

// コマンド要素のブロックを解析する。
template <
	class C, // 解析した要素を格納したコンテナの型。
	class I  // 要素の入力反復子の型。
> ptr<C> // 解析した要素を格納したコンテナ。
command_parse_blocks(
    I ele_fir,              // 最初の要素の入力反復子。
	I ele_las,              // 最後の要素の入力反復子。
    const std::string& ope, // 開く記号。
    const std::string& clo, // 閉じる記号。
    bool esc,               // エスケープを考慮するか。
    bool lea                // 全角文字を考慮するか。
) {
	auto eles = initialize<C>();
	command_parse_blocks(ele_fir, ele_las, pybot::back_inserter(*eles), ope, clo, esc, lea);
	return eles;
}

// コマンド要素のブロックを解析する。
template <
    class I, // 要素の入力反復子の型。
    class O  // 要素の出力反復子の型。
> void command_parse_blocks(
    I ele_fir,              // 最初の要素の入力反復子。
    I ele_las,              // 最後の要素の入力反復子。
    O ele_out,              // 要素の出力反復子。
    const std::string& ope, // 開く記号。
    const std::string& clo, // 閉じる記号。
    bool esc,               // エスケープを考慮するか。
    bool lea                // 全角文字を考慮するか。
) {
    int out_fra = 0;
    int ins_fra = 0;
    for (auto ele_ite = ele_fir; ele_ite != ele_las;) {
        auto ele = *ele_ite++;
        if (out_fra ||
            ele->type != CET_LITERAL
        ) {
            if (ele->type == CET_OPEN) ++out_fra;
            else if (ele->type == CET_CLOSE) {
                if (!out_fra--) RAISE_RUNTIME_ERROR("Too many close.");
            }
            *ele_out++ = ele;
        } else {
            std::stringstream buf;
            for (int i = 0; i < ele->text.length();) {
                uint8_t let = ele->text[i];
                if ((esc &&
                        let == '\\'
                    ) || (lea &&
                        letter_is_jlead(let)
                    )
                ) {
                    if (++i == ele->text.length())
                        RAISE_RUNTIME_ERROR("Wrong end.");
                    buf << let << ele->text[i++];
                } else if (ins_fra &&
                    ele->text.substr(i, clo.length()) == clo
                ) {
                    --ins_fra;
                    *ele_out++ = initialize<command_element>(CET_LITERAL, buf.str());
                    buf.str("");
                    *ele_out++ = initialize<command_element>(CET_CLOSE, clo);
                    i += clo.length();
                } else if (ele->text.substr(i, ope.length()) == ope) {
                    ++ins_fra;
                    *ele_out++ = initialize<command_element>(CET_LITERAL, buf.str());
                    buf.str("");
                    *ele_out++ = initialize<command_element>(CET_OPEN, ope);
                    i += ope.length();
                } else {
                    buf << let;
                    ++i;
                }
            }
            *ele_out++ = initialize<command_element>(CET_LITERAL, buf.str());
        }
    }
    if (out_fra ||
        ins_fra
    ) RAISE_RUNTIME_ERROR("Too many open.");
}

// コマンド要素のトークンを解析する。
template <
	class C, // 解析した要素を格納したコンテナの型。
	class I  // 要素の入力反復子の型。
> ptr<C> // 解析した要素を格納したコンテナ。
command_parse_tokens(
    I ele_fir,              // 最初の要素の入力反復子。
	I ele_las,              // 最後の要素の入力反復子。
    const std::string& sep, // 区切る記号。
    bool esc,               // エスケープを考慮するか。
    bool lea                // 全角文字を考慮するか。
) {
	auto eles = initialize<C>();
	command_parse_tokens(ele_fir, ele_las, pybot::back_inserter(*eles), sep, esc, lea);
	return eles;
}

// コマンド要素のトークンを解析する。
template <
	class I, // 要素の入力反復子の型。
	class O  // 要素の出力反復子の型。
> void command_parse_tokens(
    I ele_fir,              // 最初の要素の入力反復子。
	I ele_las,              // 最後の要素の入力反復子。
    O ele_out,              // 要素の出力反復子。
    const std::string& sep, // 区切る記号。
    bool esc,               // エスケープを考慮するか。
    bool lea                // 全角文字を考慮するか。
) {
    int fra = 0;
    for (auto ele_ite = ele_fir; ele_ite != ele_las;) {
        auto ele = *ele_ite++;
        if (fra ||
            ele->type != CET_LITERAL
        ) {
            if (ele->type == CET_OPEN) ++fra;
            else if (ele->type == CET_CLOSE) {
                if (!fra--) RAISE_RUNTIME_ERROR("Too many close.");
            }
            *ele_out++ = ele;
        } else {
			std::stringstream buf;
			for (int i = 0; i < ele->text.length();) {
				uint8_t let = ele->text[i];
				if ((esc &&
						let == '\\'
					) || (lea &&
						letter_is_jlead(let)
					)
				) {
					if (++i == ele->text.length())
						RAISE_RUNTIME_ERROR("Wrong end.");
					buf << let << ele->text[i++];
				}
				else if (ele->text.substr(i, sep.length()) == sep) {
					*ele_out++ = initialize<command_element>(CET_LITERAL, buf.str());
					buf.str("");
					*ele_out++ = initialize<command_element>(CET_SEPARATOR, sep);
					i += sep.length();
				} else {
					buf << let;
					++i;
				}
			}
			*ele_out++ = initialize<command_element>(CET_LITERAL, buf.str());
		}
    }
    if (fra) RAISE_RUNTIME_ERROR("Too many open.");
}

// コマンド要素のコンテナを書く。
template <
	class C, // 書いた文字列を格納したコンテナの型。
	class I  // 要素のコンテナの入力反復子の型。
> ptr<C> // 書いた文字列を格納したコンテナ。
command_print_all(
	I eles_fir, // 最初の要素のコンテナの入力反復子。
	I eles_las  // 最後の要素のコンテナの入力反復子。
) {
	auto strs = initialize<C>();
	command_print_all(eles_fir, eles_las, pybot::back_inserter(*strs));
	return strs;
}

// コマンド要素のコンテナを書く。
template <
	class I, // 要素のコンテナの入力反復子の型。
	class O  // テキストの出力反復子の型。
> void command_print_all(
	I eles_fir, // 最初の要素のコンテナの入力反復子。
	I eles_las, // 最後の要素のコンテナの入力反復子。
	O tex_out   // テキストの出力反復子。
) {
    for (auto eles_ite = eles_fir; eles_ite != eles_las;) {
        auto eles = *eles_ite++;
        *tex_out++ = command_print(ALL_RANGE(*eles));
    }
}

// コマンド要素を書く。
template <
	class I // 要素の入力反復子の型。
> std::string // 書いたテキスト。
command_print(
	I ele_fir, // 最初の要素の入力反復子。
	I ele_las  // 最後の要素の入力反復子。
) {
    std::stringstream buf;
    for (auto ele_ite = ele_fir; ele_ite != ele_las;) {
        auto ele = *ele_ite++;
        buf << ele->text;
    }
    return buf.str();
}

// オブジェクトを構築する。
template <
	class T,   // オブジェクトの型。
	class ...A // 一連の引数の型。
> ptr<T> // 構築したオブジェクト。
construct(
	A&& ...args // 一連の引数。
) {
    return ptr<T>(new T(args...));
}

// マップからデータを探す。
template <
	class M // マップの型。
> typename M::mapped_type // 見つかったデータ。見つからなかったらdef。
find_map_data(
	const M& map,               // マップ。
	typename M::key_type key,   // キー。
	typename M::mapped_type def // デフォルトのデータ。
) {
	auto val_ite = map.find(key);
	if (val_ite == map.end()) return def;
	return val_ite->second;
}

// マップからキーを探す。
template <
	class M // マップの型。
> typename M::key_type // 見つかったキー。見つからなかったらdef。
find_map_key(
	const M& map,                // マップ。
	typename M::mapped_type dat, // データ。
	typename M::key_type def     // デフォルトのキー。
) {
	for (auto& val : map) {
		if (val.second == dat) return val.first;
	}
	return def;
}

// 配列から名前を探す。
template <
	class A // 配列の型。
> int // 見つかったインデックス。見つからなかったらINT_MIN。
find_name(
	const A& arr,             // 配列。
	const std::string& nam_lc // 小文字の名前。
) {
	for (int i = 0; i < arr.size(); ++i) {
		if (lowercase(arr[i]) == nam_lc) return i;
	}
	return INT_MIN;
}

// オブジェクトを初期化する。
template <
	class T,   // オブジェクトの型。
	class ...A // 一連の引数の型。
> ptr<T> // 初期化したオブジェクト。
initialize(
	A&& ...args // 一連の引数。
) {
    return ptr<T>(new T{args...});
}

// 文字列を連結する。
template <
	class I // 文字列の入力反復子の型。
> std::string // 連結した文字列。
concatinate_strings(
	I str_fir,             // 最初の文字列の入力反復子。
	I str_las,             // 最後の文字列の入力反復子。
	const std::string& sep // 区切る記号。
) {
	std::stringstream out;
	for (I str_ite = str_fir; str_ite != str_las;) {
		if (str_ite != str_fir) out << sep;
		out << *str_ite++;
	}
	return out.str();
}

// 要素を探す。
template <
	class I, // 入力反復子の型。
	class P  // 述語の型。
> typename I::value_type // 見つかった要素。見つからなかったらdef。
find_if(
	I fir,                     // 最初の要素の入力反復子。
	I las,                     // 最後の要素の入力反復子。
	P pre,                     // 述語。
	typename I::value_type def // デフォルト値。
) {
	auto ele_ite = std::find_if(fir, las, pre);
	if (ele_ite == las) return def;
	return *ele_ite;
}

// 一連の引数を書く。
template <
	class ...A // 一連の引数の型。
> std::string // 書いた文字列。
print(
	A&& ...args // 一連の引数。
) {
    return print_with("", args...);
}

// 主なステータスを書く。
template <
	class D // データの型。
> std::string // 書いたステータス。
print_main_status(
	D* dat // データ。
) {
	block_list* bl = (block_list*)(dat);
	std::stringstream out;
	int aspd = 2000 - status_get_adelay(bl) / 2;
	out <<
		"HP "  << status_get_hp(bl)                     << "/" <<
		status_get_max_hp(bl)                           << " "
		"SP "  << status_get_sp(bl)                     << "/" <<
		status_get_max_sp(bl)                           << " "
		"Str " << status_get_base_str(dat)              << "+" <<
		(status_get_str(bl) - status_get_base_str(dat)) << " "
		"Agi " << status_get_base_agi(dat)              << "+" <<
		(status_get_agi(bl) - status_get_base_agi(dat)) << " "
		"Vit " << status_get_base_vit(dat)              << "+" <<
		(status_get_vit(bl) - status_get_base_vit(dat)) << " "
		"Int " << status_get_base_int(dat)              << "+" <<
		(status_get_int(bl) - status_get_base_int(dat)) << " "
		"Dex " << status_get_base_dex(dat)              << "+" <<
		(status_get_dex(bl) - status_get_base_dex(dat)) << " "
		"Luk " << status_get_base_luk(dat)              << "+" <<
		(status_get_luk(bl) - status_get_base_luk(dat)) << "\n";
	out <<
		"Atk "      << pc_leftside_atk (dat)      << "+" <<
		pc_rightside_atk (dat)                    << " "
		"Matk "     << pc_leftside_matk(dat)      << "+" <<
		pc_rightside_matk(dat)                    << " "
		"Hit "      << status_get_hit(bl)         << " "
		"Critical " << print(
			std::fixed,
			std::setprecision(1),
			status_get_critical(bl) / 10.
		) << " "
		"Def "      << int(pc_leftside_def (dat)) << "+" <<
		pc_rightside_def (dat)                    << " "
		"Mdef "     << int(pc_leftside_mdef(dat)) << "+" <<
		pc_rightside_mdef(dat)                    << " "
		"Flee "     << status_get_flee(bl)        << "+" <<
		status_get_flee2 (bl)                     << " "
		"Aspd "     << print(
			std::fixed,
			std::setprecision(1),
			aspd / 10.
		) << "\n";
	return out.str();
}

// 一連の引数を区切りながら出力ストリームに書く。
template <
	class O,   // 出力ストリームの型。
	class L,   // 先頭の引数の型。
	class ...T // 後続の引数の型。
> void print_to_with(
	O& out,                 // 出力ストリーム。
	const std::string& sep, // 区切る記号。
	L lea,                  // 先頭の引数。
	T&& ...tras             // 後続の引数の型。
) {
    out << lea;
    if (!sep.empty()) out << sep;
    print_to_with(out, sep, tras...);
}

// 引数を区切りながら出力ストリームに書く。
template <
	class O, // 出力ストリームの型。
	class A  // 引数の型。
> void print_to_with(
	O& out,                 // 出力ストリーム。
	const std::string& sep, // 区切る記号。
	A arg                   // 引数。
) {
    out << arg;
}

// 一連の引数を区切りながら書く。
template <
	class ...A // 一連の引数の型。
> std::string // 書いた文字列。
print_with(
	const std::string& sep, // 区切る記号。
	A&& ...args             // 一連の引数。
) {
    std::ostringstream out;
    print_to_with(out, sep, args...);
    return out.str();
}

// メンバ関数を、インスタンスを引数とする関数に変換する。
template <
	class T,   // オブジェクトの型。
	class R,   // 戻り値の型。
	class ...A // 一連の引数の型。
> std::function<R(T*,A...)> // 変換した関数。
unbind(
	R(T::*mem_fun)(A...) // メンバ関数。
) {
	return [mem_fun] (
		T* ins,     // インスタンス。
		A&& ...args // 一連の引数。
	) -> R { // 戻り値。
		return (ins->*mem_fun)(args...);
	};
}

}

#endif
