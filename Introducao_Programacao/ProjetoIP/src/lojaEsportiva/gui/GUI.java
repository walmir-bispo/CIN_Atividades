package lojaEsportiva.gui;

import java.util.Scanner;

import lojaEsportiva.dados.*;
import lojaEsportiva.exceptions.*;
import lojaEsportiva.negocio.*;
import lojaEsportiva.fachada.Fachada;


public class GUI {

	public static void main(String[] args) {
		//Fachada fachada = new Fachada(new CadastroVendas(new RepositorioVendasArray()),
		//		new Cadastroprodutos(new RepositorioProdutoArray()),
		//		new CadastroFornecedor(new RepositorioArray()),
		//		new CadastroFuncionarios(new RepositorioFuncionariosArray()),
		//		new CadastroCliente(new RepositorioClienteArray()));
		Fachada fachada = new Fachada(new CadastroVendas(new RepositorioVendasLista()),
				new Cadastroprodutos(new RepositorioProdutosLista()),
				new CadastroFornecedor(new RepositorioLista()),
				new CadastroFuncionarios(new RepositorioFuncionariosLista()),
				new CadastroCliente(new RepositorioListaCliente()));
		Scanner t = new Scanner(System.in);
		int op;
		do {
			System.out.println("1 - Menu de Produtos");
			System.out.println("2 - Menu de Clientes");
			System.out.println("3 - Menu de Funcionarios");
			System.out.println("4 - Menu de Fornecedores");
			System.out.println("5 - Menu de Vendas");
			System.out.println("0 - Sair");
			System.out.print("Digite sua escolha: ");
			op = t.nextInt();
			int opSubmenu;
			switch(op) {
			case 1:
				//Menu Produtos
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Consultar");
				System.out.println("3 - Remover");
				System.out.println("4 - Alterar");
				System.out.print("Digite sua opção: ");
				opSubmenu = t.nextInt();
				t.nextLine();
				switch(opSubmenu) {
				case 1:
					//Produto pro = new Produto(tamanho, modelo, marca, identificador, tipo, preco)
					String tamanho, modelo, marca, id, tipo;
					double preco;
					System.out.print("Digite o tipo do Produto: ");
					tipo = t.nextLine();
					System.out.print("Digite a marca do Produto: ");
					marca = t.nextLine();
					System.out.print("Digite o modelo do Produto: ");
					modelo = t.nextLine();
					System.out.print("Digite o tamanho do Produto: ");
					tamanho = t.nextLine();
					System.out.print("Digite o ID do Produto: ");
					id = t.nextLine();
					System.out.print("Digite o preço do Produto: ");
					preco = Double.parseDouble(t.nextLine());
					try {
						fachada.cadastrarProduto(new Produto(tamanho, modelo, marca, id, tipo, preco));
						System.out.println("Cadastro realizado com sucesso!");
					} catch (ProdutoJaCadastradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.print("Digite o ID do Produto: ");
					id = t.nextLine();
					Produto produto;
					try {
						produto = fachada.procurarProduto(id);
						System.out.println("\n\tTipo: " + produto.getTipo());
						System.out.println("\tMarca: " + produto.getMarca());
						System.out.println("\tModelo: " + produto.getModelo());
						System.out.println("\tTamanho: " + produto.getTamanho());
						System.out.println("\tPreço: " + produto.getPreco() + "\n");
					} catch (ProdutoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.print("Digite o ID do Produto que desejas remover: ");
					try {
						fachada.removerProduto(t.nextLine());
						System.out.println("Produto removido dos registros!");
					} catch (ProdutoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.print("Digite o ID do Produto que desejas atualizar: ");
					id = t.nextLine();
					System.out.print("Digite o tipo do Produto: ");
					tipo = t.nextLine();
					System.out.print("Digite a marca do Produto: ");
					marca = t.nextLine();
					System.out.print("Digite o modelo do Produto: ");
					modelo = t.nextLine();
					System.out.print("Digite o tamanho do Produto: ");
					tamanho = t.nextLine();
					System.out.print("Digite o preço do Produto: ");
					preco = Double.parseDouble(t.nextLine());
					try {
						fachada.atualizarProduto(new Produto(tamanho, modelo, marca, id, tipo, preco));
						System.out.println("Registro de produto atualizado!");
					} catch (ProdutoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Opção Inválida");
					break;
				}
				break;
			case 2:
				//Menu Clientes
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Consultar");
				System.out.println("3 - Remover");
				System.out.println("4 - Alterar");
				System.out.print("Digite sua opção: ");
				opSubmenu = t.nextInt();
				t.nextLine();
				switch(opSubmenu) {
				case 1:
					String nome, endereco, contato, cpf;
					System.out.print("Digite o nome do Cliente: ");
					nome = t.nextLine();
					System.out.print("Digite o contato do Cliente: ");
					contato = t.nextLine();
					System.out.print("Digite o endereço do Cliente: ");
					endereco = t.nextLine();
					System.out.print("Digite o CPF do Cliente: ");
					cpf = t.nextLine();
					try {
						fachada.cadastrarCliente(new Cliente(nome, endereco, contato, cpf));
						System.out.println("Cadastro realizado com sucesso!");
					} catch (ClienteJaCadastradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.print("Digite o CPF do Cliente: ");
					cpf = t.nextLine();
					Cliente cliente;
					try {
						cliente = fachada.procurarCliente(cpf);
						System.out.println("\n\tNome: " + cliente.getNome());
						System.out.println("\tContato: " + cliente.getContato());
						System.out.println("\tEndereço: " + cliente.getEndereco() + "\n");
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.print("Digite o CPF do Cliente que desejas remover: ");
					try {
						fachada.removerCliente(t.nextLine());
						System.out.println("Cliente removido dos registros!");
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.print("Digite o CPF do Cliente que desejas atualizar: ");
					cpf = t.nextLine();
					System.out.print("Digite o nome do Cliente: ");
					nome = t.nextLine();
					System.out.print("Digite o contato do Cliente: ");
					contato = t.nextLine();
					System.out.print("Digite o endereço do Cliente: ");
					endereco = t.nextLine();
					try {
						fachada.atualizarCliente(new Cliente(nome, endereco, contato, cpf));
						System.out.println("Registro de Cliente atualizado!");
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Opção Inválida");
					break;
				}
				break;
			case 3:
				//Menu Funcionarios
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Consultar");
				System.out.println("3 - Remover");
				System.out.println("4 - Alterar");
				System.out.print("Digite sua opção: ");
				opSubmenu = t.nextInt();
				t.nextLine();
				switch(opSubmenu) {
				case 1:
					String nome, endereco, contato, numeroConta, idFuncionario, rg, cpf;
					System.out.print("Digite o nome do Funcionario: ");
					nome = t.nextLine();
					System.out.print("Digite o contato do Funcionario: ");
					contato = t.nextLine();
					System.out.print("Digite o endereço do Funcionario: ");
					endereco = t.nextLine();
					System.out.print("Digite o numero da conta do Funcionario: ");
					numeroConta = t.nextLine();
					System.out.print("Digite o RG do Funcionario: ");
					rg = t.nextLine();
					System.out.print("Digite o CPF do Funcionario: ");
					cpf = t.nextLine();
					System.out.print("Digite o Identificador Próprio do Funcionario: ");
					idFuncionario = t.nextLine();
					try {
						fachada.cadastrarFuncionario(new Funcionarios(rg, numeroConta, idFuncionario, nome, endereco, contato, cpf));
						System.out.println("Cadastro realizado com sucesso!");
					} catch (FuncionarioJaCadastradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.print("Digite o ID do Funcionario: ");
					idFuncionario = t.nextLine();
					Funcionarios funcionario;
					try {
						funcionario = fachada.procurarFuncionario(idFuncionario);
						System.out.println("\n\tNome: " + funcionario.getNome());
						System.out.println("\tContato: " + funcionario.getContato());
						System.out.println("\tEndereço: " + funcionario.getEndereco());
						System.out.println("\tCPF: " + funcionario.getId());
						System.out.println("\tRG: " + funcionario.getRg());
						System.out.println("\tNumero da Conta: " + funcionario.getNumeroConta() + "\n");
					} catch (FuncionarioNaoExistenteException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.print("Digite o ID do Funcionario que desejas remover: ");
					try {
						fachada.removerFuncionario(t.nextLine());
						System.out.println("Funcionario removido dos registros!");
					} catch (FuncionarioNaoExistenteException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.print("Digite o ID do Funcionario que desejas atualizar: ");
					idFuncionario = t.nextLine();
					System.out.print("Digite o nome do Funcionario: ");
					nome = t.nextLine();
					System.out.print("Digite o contato do Funcionario: ");
					contato = t.nextLine();
					System.out.print("Digite o endereço do Funcionario: ");
					endereco = t.nextLine();
					System.out.print("Digite o numero da conta do Funcionario: ");
					numeroConta = t.nextLine();
					System.out.print("Digite o RG do Funcionario: ");
					rg = t.nextLine();
					System.out.print("Digite o CPF do Funcionario: ");
					cpf = t.nextLine();
					try {
						fachada.atualizarFuncionario(new Funcionarios(rg, numeroConta, idFuncionario, nome, endereco, contato, cpf));
						System.out.println("Registro de Funcionario atualizado!");
					} catch (FuncionarioNaoExistenteException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Opção Inválida");
					break;
				}
				break;
			case 4:
				//Menu Fornecedores
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Consultar");
				System.out.println("3 - Remover");
				System.out.println("4 - Alterar");
				System.out.print("Digite sua opção: ");
				opSubmenu = t.nextInt();
				t.nextLine();
				switch(opSubmenu) {
				case 1:
					String nome, endereco, contato, tipoProduto, cnpj;
					System.out.print("Digite o nome do Fornecedor: ");
					nome = t.nextLine();
					System.out.print("Digite o contato do Fornecedor: ");
					contato = t.nextLine();
					System.out.print("Digite o endereço do Fornecedor: ");
					endereco = t.nextLine();
					System.out.print("Digite o tipo de produto com os quais o Fornecedor trabalha: ");
					tipoProduto = t.nextLine();
					System.out.print("Digite o CNPJ do Fornecedor: ");
					cnpj = t.nextLine();
					try {
						fachada.cadastrarFornecedor(new Fornecedor(nome, endereco, contato, tipoProduto, cnpj));
						System.out.println("Cadastro realizado com sucesso!");
					} catch (FornecedorJaCadastradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.print("Digite o CNPJ do Fornecedor: ");
					cnpj = t.nextLine();
					Fornecedor fornecedor;
					try {
						fornecedor = fachada.procurarFornecedor(cnpj);
						System.out.println("\n\tNome: " + fornecedor.getNome());
						System.out.println("\tContato: " + fornecedor.getContato());
						System.out.println("\tEndereço: " + fornecedor.getEndereco());
						System.out.println("\tTipos de produto fornecidos: " + fornecedor.getTipoProduto() + "\n");
					} catch (FornecedorNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.print("Digite o CNPJ do Fornecedor que desejas remover: ");
					try {
						fachada.removerFornecedor(t.nextLine());
						System.out.println("Fornecedor removido dos registros!");
					} catch (FornecedorNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.print("Digite o CNPJ do Fornecedor que desejas atualizar: ");
					cnpj = t.nextLine();
					System.out.print("Digite o nome do Fornecedor: ");
					nome = t.nextLine();
					System.out.print("Digite o contato do Fornecedor: ");
					contato = t.nextLine();
					System.out.print("Digite o endereço do Fornecedor: ");
					endereco = t.nextLine();
					System.out.print("Digite o tipo de produto com os quais o Fornecedor trabalha: ");
					tipoProduto = t.nextLine();
					try {
						fachada.atualizarFornecedor(new Fornecedor(nome, endereco, contato, tipoProduto, cnpj));
						System.out.println("Registro de Fornecedor atualizado!");
					} catch (FornecedorNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Opção Inválida");
					break;
				}
				break;
			case 5:
				//Menu Vendas
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Consultar");
				System.out.println("3 - Remover");
				System.out.println("4 - Alterar");
				System.out.print("Digite sua opção: ");
				opSubmenu = t.nextInt();
				t.nextLine();
				switch(opSubmenu) {
				case 1:
					String idProduto, idCliente, idFuncionario, idVenda;
					System.out.print("Digite o ID do Produto: ");
					idProduto = t.nextLine();
					System.out.print("Digite o ID do Cliente: ");
					idCliente = t.nextLine();
					System.out.print("Digite o ID do Funcionario: ");
					idFuncionario = t.nextLine();
					System.out.print("Digite o ID da Venda: ");
					idVenda = t.nextLine();
					try {
						Produto	produto = fachada.procurarProduto(idProduto);
						Cliente cliente = fachada.procurarCliente(idCliente);
						Funcionarios funcionario = fachada.procurarFuncionario(idFuncionario);
						fachada.cadastrarVenda(new Venda(produto, cliente, funcionario, idVenda));
						System.out.println("Cadastro realizado com sucesso!");
					} catch (VendaJaCadastradaException e) {
						System.out.println(e.getMessage());
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (FuncionarioNaoExistenteException e) {
						System.out.println(e.getMessage());
					} catch (ProdutoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					try {
						System.out.print("Digite o ID da venda: ");
						Venda venda = fachada.procurarVenda(t.nextLine());
						System.out.println("\nCliente: " + venda.getCliente().getNome());
						System.out.println("\tCPF: " + venda.getCliente().getId());
						System.out.println("\tContato: " + venda.getCliente().getContato());
						System.out.println("\tEndereço: " + venda.getCliente().getEndereco());
						System.out.println("\nFuncionario: " + venda.getFuncionario().getNome());
						System.out.println("\tID: " + venda.getFuncionario().getIdFuncionario());
						System.out.println("\tContato: " + venda.getFuncionario().getContato());
						System.out.println("\tNúmero da Conta: " + venda.getFuncionario().getNumeroConta());
						System.out.println("\nProduto: " + venda.getProduto().getTipo());
						System.out.println("\tMarca: " + venda.getProduto().getMarca());
						System.out.println("\tModelo: " + venda.getProduto().getPreco());
						System.out.println("\tID: " + venda.getProduto().getIdentificador() + "\n");
					} catch (VendaNaoEncontradaException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					try {
						System.out.print("Digite o ID da venda que desejas remover: ");
						fachada.removerVenda(t.nextLine());
						System.out.println("Venda removida dos registros!");
					} catch (VendaNaoEncontradaException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.print("Digite o ID do novo Produto: ");
					idProduto = t.nextLine();
					System.out.print("Digite o ID do novo Cliente: ");
					idCliente = t.nextLine();
					System.out.print("Digite o ID do novo Funcionario: ");
					idFuncionario = t.nextLine();
					System.out.print("Digite o ID da Venda que desejas atualizar: ");
					idVenda = t.nextLine();
					try {	
						Produto produto = fachada.procurarProduto(idProduto);
					Cliente cliente = fachada.procurarCliente(idCliente);
					Funcionarios funcionario = fachada.procurarFuncionario(idFuncionario);
					fachada.atualizarVenda(new Venda(produto, cliente, funcionario, idVenda));
					System.out.println("Registro de venda atualizado!");
					} catch (ProdutoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (FuncionarioNaoExistenteException e) {
						System.out.println(e.getMessage());
					} catch (VendaNaoEncontradaException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Opção Inválida");
					break;
				}
				break;
			case 0:
				System.out.println("\n\nObrigado por usar nosso sistema!");
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while(op != 0);
	}

}