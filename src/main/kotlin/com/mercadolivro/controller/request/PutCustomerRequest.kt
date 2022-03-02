package com.mercadolivro.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PutCustomerRequest (
    @field:NotEmpty(message = "name cannot be empty")
    var name: String,

    @field:Email(message = "email must be valid")
    var email: String
)