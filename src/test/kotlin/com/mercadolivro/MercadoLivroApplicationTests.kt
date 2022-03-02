package com.mercadolivro

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MercadoLivroApplicationTests {


	@Test
	fun testeSoma() {
		val value: Int = 7
		val anotherValue: Int = 3
		var resultado: Int = value + anotherValue
		assertEquals(10, resultado)
	}

}
