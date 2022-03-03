package com.mercadolivro.service

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class CustomerServiceTest {
    @MockK
    private lateinit var customerRepository: CustomerRepository // Classe que não faz nada

    @MockK
    private lateinit var bookService: BookService // Classe Dwam

    @InjectMockKs
    private lateinit var customerService: CustomerService // injetando classe com os mocks

    fun buildCustomer(
            id: Int? = null,
            name: String = "customer_name",
            email: String = "${UUID.randomUUID()}@email.com"
    ) = CustomerModel (
            id = id,
            name = name,
            email = email,
            status = CustomerStatus.ATIVO
    )

    @Test // fala que é uma função de teste
    fun `deve retornar todos os customers`() {

        val fakeCustomer = listOf(buildCustomer(), buildCustomer())

        every { customerRepository.findAll() } returns fakeCustomer

        val customers = customerService.getAll(null)

        assertEquals(fakeCustomer, customers)
        verify(exactly = 1) {customerRepository.findAll()}
        verify(exactly = 0) { customerRepository.findByNameContaining(any()) }
    }

    @Test // fala que é uma função de teste
    fun `deve retornar o customer quando passarmos o nome`() {
        val name = UUID.randomUUID().toString()
        val fakeCustomer = listOf(buildCustomer(), buildCustomer())

        every { customerRepository.findByNameContaining(name) } returns fakeCustomer

        val customers = customerService.getAll(name)

        assertEquals(fakeCustomer, customers)
        verify(exactly = 0) {customerRepository.findAll()}
        verify(exactly = 1) { customerRepository.findByNameContaining(name) }
    }

}