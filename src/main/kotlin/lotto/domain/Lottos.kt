package lotto.domain

import lotto.util.NumberGenerator

class Lottos(
    buyingPrice: LottoBuyingPrice,
    lottoNumberGenerator: NumberGenerator,
) {

    private val _lottos: MutableList<Lotto> = mutableListOf()
    val lottos: List<Lotto>
        get() = _lottos

    init {
        val lottoCount = buyingPrice.divide(LOTTO_PRICE)
        for (i in 0 until lottoCount) {
            val lottoNumbers = lottoNumberGenerator.generate(lottoCount)
            val lotto = Lotto(lottoNumbers)
            _lottos.add(lotto)
        }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
