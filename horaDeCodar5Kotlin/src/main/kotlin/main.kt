var saldo = 3600
var nome: String = null.toString()

fun main(){
    print("Qual é o seu nome: ")
    nome = readln()

    println("Olá, $nome, é um prazer ter você por aqui!")

    print("Me informe a senha da sua conta bancária: ")
    val senha = readln()?.toInt()

    if(senha == 3589){
        inicio()
    }else{
        println("Senha incorreta!")
        println("Insira os dados corretos!")
        main()
    }
}

fun inicio(){
    println("Qual função gostaria de realizar?")
    println("1 - Saldo.\n2 - Extrato.\n3 - Saque.\n4 - Depósito.\n5 - Transferência.\n6 - Sair.")
    val funcao = readln()!!.toInt()

    when(funcao){
        1 -> saldo()
        2 -> extrato()
        3 -> saque()
        4 -> deposito()
        5 -> transferencia()
        6 -> sair()
        else -> erro()
    }
}

fun saldo(){
    print("Digite a sua senha: ")
    var senha = readln()!!.toInt()

    if(senha != 3589){
        println("Operação não autorizada.\n")
        saldo()
    }
        println("O seu saldo atual é de $saldo\n")
        inicio()
}

fun extrato(){
    print("Digite a sua senha: ")
    val senha = readln()!!.toInt()

    if(senha != 3589){
        println("Operação não autorizada.\n")
        extrato()
    }
        print("Extrato atual:\nR$25.45 - Burguer King - 20:14 20/08/2044\nR$80.79 - FarmaConde - 10:25 18/08/2024\nR$120.00 - Luiz Pipa - 09:30 10/08/2024\n")
        inicio()
}

fun saque(){
    print("Digite a sua senha: ")
    val senha = readln()!!.toInt()

    if(senha != 3589){
        println("Operação não autorizada.\n")
        saque()
    }
    print("Quanto é o valor que você gostaria de sacar: ")
    val take = readln()!!.toInt()

    if(take!!.compareTo(saldo) > 0){
        print("Operação não autorizada.\n")
        saque()
    }else if(take <= 0){
        print("Operação não autorizada.\n")
        saque()
    }else{
        saldo = saldo - take

        println("O valor do saque foi de R$$take, o seu saldo atual é de R$$saldo.\n")
        inicio()
    }
}

fun deposito(){
    print("Digite a sua senha: ")
    val senha = readln()!!.toInt()

    if(senha != 3589){
        print("Operação não autorizada.\n")
        deposito()
    }

    print("Qual será o valor do depósito: ")
    var dep = readln()!!.toInt()

    if(dep < 0){
        print("Operação não autorizada.\n")
        deposito()
    }

    saldo = saldo + dep
    println("O valor do depósito foi de R$$dep, seu saldo atual é de R$$saldo.\n")
    inicio()
}

fun transferencia(){
    print("Digite a sua senha: ")
    val senha = readln()!!.toInt()

    if(senha != 3589){
        print("Operação não autorizada.\n")
        transferencia()
    }

    print("Qual conta você vai transferir: ")
    val trans = readln()!!.toInt()

    if(trans != 2807){
        print("Operação não autorizada.\n")
        transferencia()
    }

    print("Qual o valor da transferência: ")
    val valor = readln()!!.toInt()

    if(valor > saldo || valor <= 0){
        print("Operação não autorizada.\n")
        transferencia()
    }else{
        saldo = saldo - valor
        println("Transferência realizada com SUCESSO!\nValor transferido: R$$valor.\nSaldo Atual:R$$saldo.\n")
    }
    inicio()
}

fun sair(){
    print("$nome, foi um prazer ter você por aqui!")
}

fun erro(){
    println("Opção não autorizada!\nPor favor insira uma opção válida\n")
    main()
}