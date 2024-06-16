package com.fourprograms.safeguardpro.service.model

data class Epi(
    var id: Int = 0,
    var tipo: String = "",
    var descricao: String = "",
    var validade: String = "",
    var uso_coletivo: String = "",
    var certificado_aprovacao: Int = 0,
)