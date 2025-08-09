package com.kfh.assessment.data.net
import okhttp3.CertificatePinner
object CertificatePinnerFactory {
  private val PINS = arrayOf(
    "sha256/BlTaEEhpHekhOFXEfomfGqmW5oc3cdFfhJeKlPOzNdU=",
    "sha256/Wec45nQiFwKvHtuHxSAMGkt19k+uPSw9JlEkxhvYPHk=",
    "sha256/BlTaEEhpHekhOFXEfomfGqmW5oc3cdFfhJeKlPOzNdU=",
    "sha256/i7WTqTvh0OioIruIfFR4kMPnBqrS2rdiVPl/s2uC/CY=",
    "sha256/ExwF6nQ/RYQLplGVa3YaKNKxWuZA6UeBo1+HG3cYyHg="
  )
  fun bitbucket(): CertificatePinner =
    CertificatePinner.Builder().add("api.bitbucket.org", *PINS).build()
}
