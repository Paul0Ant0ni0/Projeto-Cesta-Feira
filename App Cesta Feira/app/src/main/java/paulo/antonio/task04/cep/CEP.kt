package paulo.antonio.task04.cep

class CEP {

        var cep: String? = ""
        var logradouro: String? = ""
        var complemento: String? = ""
        var bairro: String? = ""
        var localidade: String? = ""
        var uf: String? = ""
        var unidade: String? = ""
        var ibge: String? = ""
        var gia: String? = ""

        override fun toString(): String {

            return  "$cep" +
                    "\n Logradouro: $logradouro" +
                    "\n Complemento: $complemento" +
                    "\n Bairro: $bairro" +
                    "\n Localidade: $localidade" +
                    "\n UF: $uf" +
                    "\n Unidade: $unidade"
        }

}