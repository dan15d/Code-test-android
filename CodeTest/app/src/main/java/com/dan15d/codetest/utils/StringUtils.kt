package com.dan15d.codetest.utils

import java.nio.charset.StandardCharsets
import java.util.Base64

class StringUtils {
    companion object {
        fun toUTF8Base64(texto: String): String {
            val bytesUTF8 = texto.toByteArray(StandardCharsets.UTF_8)
            return Base64.getEncoder().encodeToString(bytesUTF8)
        }

        // Función para decodificar de Base64 y luego de UTF-8
        fun fromUTF8Base64(textoBase64: String): String {
            val bytesUTF8 = Base64.getDecoder().decode(textoBase64)
            return String(bytesUTF8, StandardCharsets.UTF_8)
        }
    }
}