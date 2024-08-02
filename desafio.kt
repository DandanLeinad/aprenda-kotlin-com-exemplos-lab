enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        // Adiciona o usuário à lista de inscritos
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("${usuario.nome} foi matriculado na formação '${nome}'.")
        } else {
            println("${usuario.nome} já está matriculado na formação '${nome}'.")
        }
    }
}

fun main() {
    // Criando alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 120)
    val conteudo2 = ConteudoEducacional("Programação Funcional", 90)
    
    // Criando uma formação
    val formacao = Formacao("Formação Kotlin Completo", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))
    
    // Criando alguns usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    
    // Matriculando usuários
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1)  // Tentando matricular o mesmo usuário novamente

    // Mostrando os inscritos
    println("Inscritos na formação '${formacao.nome}': ${formacao.inscritos.map { it.nome }}")
}
