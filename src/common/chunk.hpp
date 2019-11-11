// [GonBee]
// データをチャンクに分割する。

#ifndef CHUNK_HPP
#define CHUNK_HPP

#include <cinttypes>
#include <cstring>

template <size_t D, size_t C> size_t chunk_size(uint8_t seq);
template <size_t D, size_t C> void get_chunk(void* chu, const void* dat, uint8_t seq);
template <size_t D, size_t C> void set_chunk(void* dat, const void* chu, uint8_t seq);

// チャンクのサイズを取得する。
template <
	size_t D, // データのサイズ。
	size_t C  // チャンクの最大サイズ。
> size_t // 取得したチャンクのサイズ。
chunk_size(
	uint8_t seq // シーケンス。
) {
	size_t top = C * seq;
	if (top + C > D) return D - top;
	else return C;
}

// チャンクを取得する。
template <
	size_t D, // データのサイズ。
	size_t C  // チャンクの最大サイズ。
> void get_chunk(
	void* chu,       // チャンク。
	const void* dat, // データ。
	uint8_t seq      // シーケンス。
) {
	std::memcpy(chu, dat + C * seq, chunk_size(seq));
}

// チャンクを設定する。
template <
	size_t D, // データのサイズ。
	size_t C  // チャンクの最大サイズ。
> void set_chunk(
	void* dat,       // データ。
	const void* chu, // チャンク。
	uint8_t seq      // シーケンス。
) {
	std::memcpy(dat + C * seq, chu, chunk_size(seq));
}

#endif
