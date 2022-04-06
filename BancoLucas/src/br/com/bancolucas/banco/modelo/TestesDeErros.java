package br.com.bancolucas.banco.modelo;

/**
 * @author Lucas Melo Costa
 * @serial 1L
 */
public class TestesDeErros extends Conta {

	private static final long serialVersionUID = 1L;

	protected TestesDeErros(int tipoDeConta) {
		super(tipoDeConta);
	}

	public static void main(String[] args) {

//		ContaCorrente minhaContaCorrente = new ContaCorrente();
//		ContaPoupanca minhaContaPoupanca = new ContaPoupanca();
//		
//		
//		ContaDAO contaDao2 = new ContaDAO();
//		System.out.println("\nEntre com o número da conta: ");
//		int numero = 65;  //659347705; // 310536477;
//		System.out.println(contaDao2.getTipoDeConta(numero));
//		if (contaDao2.getTipoDeConta(numero) == 001) {
//			minhaContaCorrente.mostrarDados(numero);
//		} else {
//			if (contaDao2.getTipoDeConta(numero).equals(013)) {
//				minhaContaPoupanca.mostrarDados(numero);
//			} else {
//				System.out.println("Tipo de conta não cadastrada. Tente criar uma nova conta.");
//			}
//		}			

//			Random random = new Random();
//			ContaDAO contaDao = new ContaDAO();
//			int numero = contaDao.geraNumero();

//			System.out.println(random.nextInt(5));
//			System.out.println(contaDao.geraNumero() + "deu certo?");
//			
//			Conta lucas = new ContaCorrente();
//			ContaPoupanca lucas2 = (ContaPoupanca) lucas;
//			lucas.setNumero(contaDao.geraNumero());
//			lucas.setNome("Lucasultimo");
//			lucas.setSaldo(new BigDecimal("50"));
//			lucas.setDataAtualizacao(LocalDateTime.now());
//			System.out.println(lucas.getTipoDeConta());
//			
//			LocalDateTime hoje = LocalDateTime.now().withNano(0);
//			LocalDateTime hojecompara = lucas.getDataAtualizacao().withNano(0).plusMonths(1);
//			Duration hoje2 = Duration.between(hoje, hojecompara);
//		
//			System.out.println("\nSaldo: " + lucas.getSaldo().multiply(new BigDecimal(hoje2.toMinutes() * 0.005)) + ".");
//			System.out.println(hoje);
//			System.out.println(hojecompara);
//			System.out.println(hoje2 + "    olha isso");
//			System.out.println(hoje2.toMinutes());

//			LocalDateTime hoje = LocalDateTime.now();
//			LocalDateTime hojecompara = LocalDateTime.of(2022,5,3,15,53);
//			Duration hoje2 = Duration.between(hoje, hojecompara);
//			long taxa = hoje2.toMinutes();
//			System.out.println(hojecompara2 + "    olha isso");
//			System.out.println(hojecompara + "    olha isso2");
//			System.out.println(lucas.getSaldo().multiply(new BigDecimal(hoje2.toMinutes() * 0.005)) + "novo saldo poha");
//			System.out.println(hoje2);
//			System.out.println(taxa);			

//			System.out.println(data);
//			data.setMinutes(data.getMinutes() + 1);
//			System.out.println(data);

//			contaDao.save(lucas);
//			System.out.println(lucas.getSaldo());   

//		    contaDao.deleteByID(60912136);
//		    contaDao.deleteByID(82766780);
//		    contaDao.deleteByID(51522197);
//		    contaDao.deleteByID(99882826);
//		    contaDao.deleteByID(61251177);
//			contaDao.deleteByID(374803);

//			int[] result = new int[20];
//
//			HashSet<Integer> used = new HashSet<Integer>();
//			for (int i = 0; i < 1; i++) {
//			    int add = (int) random.nextInt(5); //this is the int we are adding
//			    while (used.contains(add)) { //while we have already used the number
//			        add = (int) random.nextInt(5); //generate a new one because it's already used
//			    }
//			    //by this time, add will be unique
//			    used.add(add);
//			    result[i] = add;
//			}
//			System.out.println(used);

	}
}