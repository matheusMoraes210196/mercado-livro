package com.mercadolivro.repository

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import java.math.BigDecimal
import java.util.Optional

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private lateinit var bookRepository: BookRepository

    @Test
    fun testaValidaLivroEncontradoPorCustomer() {

        // @TODO: problemas encontrados
        // 1 - Não consegui salvar o customer nem criar um customer mokado para validar.
        val customer = CustomerModel(3, "Nome Qualquer", "email@qualquer.com", CustomerStatus.ATIVO)
        val book = BookModel(null, "Livro Teste", BigDecimal(08.22), customer, BookStatus.ATIVO)

        bookRepository.save(book)

        val livroEncontrado = bookRepository.findByCustomer(customer)

        Assertions.assertTrue(book in livroEncontrado)
    }
}