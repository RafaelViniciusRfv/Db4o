import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

public class Crud{
    public static void main(String[] args) {
        
        Cadastro cadaster = new Cadastro();
        ObjectContainer db;

        db = Db4o.openFile("cadastroCrud.dbo");
        cadaster.setNome("Rafael Vinicius");
        cadaster.setSenha("db4o_aula");
        cadaster.setCpf("12345678901");
        cadaster.setIdade("19");
        cadaster.setLocalizacao("Recife/PE");
        db.store(cadaster); 
        db.close();

        // Atualizando um objeto
        atualizarCadaster(cadaster, /*Nome, Senha, Cpf, Idade, Localizacao */"", "", "", "", "");

        // Deletando um objeto
        deletarCadaster(cadaster);

        // Listando todos os objetos
        listarCadaster();
    }

    public static void atualizarCadaster(Cadastro cadaster, String nome, String senha, String cpf, String idade, String localizacao) {
        ObjectContainer db = Db4o.openFile("cadastroCrud.dbo");
        cadaster.setNome(nome);
        cadaster.setSenha(senha);
        cadaster.setCpf(cpf);
        cadaster.setIdade(idade);
        cadaster.setLocalizacao(localizacao);
        db.store(cadaster);
        db.close();
    }

    public static void deletarCadaster(Cadastro cadaster) {
        ObjectContainer db = Db4o.openFile("cadastroCrud.dbo");
        db.delete(cadaster);
        db.close();
    }

    public static void listarCadaster() {
        ObjectContainer db = Db4o.openFile("cadastroCrud.dbo");
        ObjectSet<Cadastro> lista = db.query(Cadastro.class);
        while (lista.hasNext()){
            Cadastro cadaster = lista.next();
            System.out.println("###################");
            System.out.println(cadaster.getNome());
            System.out.println(cadaster.setSenha());
            System.out.println(cadaster.setCpf());
            System.out.println(cadaster.setIdade());
            System.out.println(cadaster.getLocalizacao());
        }
        db.close();
    }
}