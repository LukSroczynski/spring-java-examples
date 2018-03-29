package pl.braintelligence.examples.webflux.stock.quote.application.model

import java.math.BigDecimal
import java.math.MathContext

data class Quote(val ticker: String, val price: BigDecimal) {

    constructor(ticker: String, price: Double) : this(ticker, BigDecimal(price, MATH_CONTEXT))

    companion object {

        private val MATH_CONTEXT = MathContext(2)
    }
}
