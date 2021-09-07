package br.com.curso.exception

import java.time.LocalDateTime

data class ErroMessage(
        val dataHora: String = LocalDateTime.now().toString(),
        val msg: String?
)
