package Exercicio09;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AgendaTest {

	Agenda agenda;
	@Before
	public void setUp() throws Exception {
		agenda = new Agenda();
	}
	@After
	public void tearDown() throws Exception {
		File f = new File("contatos.txt");
		if(f.exists()){
			f.delete();
		}
	}
	@Test
	public void testaAdicionaContatos() {
		try{
			agenda.pesquisaContato("berg");
			fail(" não lancou a exceção que deveria!");
		}catch(ContatoInexistenteException e){
			//OK
		}
		agenda.adicionaContato("berg","333");	
		try{
			Contato c = agenda.pesquisaContato("berg");
			assertEquals("berg", c.getNome());
			assertEquals("333", c.getTelefone());
		}catch(ContatoInexistenteException e){
			fail("Contato não foi adicionado!");
		}
	}
	@Test
	public void testaAdicaoDuplicadoDoContato(){
		agenda.adicionaContato("berg", "333");
		agenda.adicionaContato("berg", "222");
		try {
			Contato c = agenda.pesquisaContato("berg");
			assertEquals("berg", c.getNome());
			assertEquals("222", c.getTelefone());
			assertTrue(c.getNome().equals("berg")
					&& c.getTelefone().equals("222"));

		} catch (ContatoInexistenteException e) {
			fail("Não era pra falhar");
		}
	}
	@Test
	public void testaPesquisa() {
		agenda.adicionaContato("José", "111");
		agenda.adicionaContato("Luzia", "444");
		try {
			Contato c1 = agenda.pesquisaContato("José");
			Contato c2 = agenda.pesquisaContato("Luzia");
			assertEquals("111", c1.getTelefone());
			assertEquals("444", c2.getTelefone());
		} catch (ContatoInexistenteException e) {
			fail("Não deveria lançar a exceção");
		}
		try {
			Contato c3 = agenda.pesquisaContato("Maria");
			fail("Deveria ter lançado a exceção pois Maria não existe");
		} catch (ContatoInexistenteException e) {
			// ok
		}
	}
	@Test
	public void testaRemocao(){
		agenda.adicionaContato("berg", "3333");
		try{
			Contato c = agenda.pesquisaContato("berg");
		}catch(ContatoInexistenteException e){
			fail("Não deveria lançar exceção, pois o contato foi adicionado.");
		}
		try{
			agenda.removerContato("berg");
		}catch(ContatoInexistenteException e){
			fail("Não deveria lançar exceção, pois o contato existe!");
		}
		try{
			agenda.pesquisaContato("berg");
			fail("Não deveria lançar exceção, pois o contato foi removido!");
		}catch(ContatoInexistenteException e){
			//OK exceção lançada, conforme o esperado!
		}
	}
	@Test
	public void testaGetContatos(){
		agenda.adicionaContato("berg","222");
		agenda.adicionaContato("italo","333");
		agenda.adicionaContato("gilson","444");
		List<Contato> list = new ArrayList<Contato>();
		list.addAll(this.agenda.getContato());
		Contato c = list.get(2);
		assertEquals("gilson",c.getNome());
		assertEquals("444",c.getTelefone());
	}
	@Test
	public void testaContatosOrdenados() {
		Iterator<Contato> contatosIt = agenda.getContatosOrdenados();
		assertTrue(contatosIt.hasNext() == false);
		assertFalse(contatosIt.hasNext());
		agenda.adicionaContato("Tereza", "555");
		agenda.adicionaContato("Maria", "222");
		contatosIt = agenda.getContatosOrdenados();
		assertTrue(contatosIt.hasNext());
		Contato c1 = contatosIt.next();
		assertEquals("Maria", c1.getNome());
		assertEquals("222", c1.getTelefone());

		assertTrue(contatosIt.hasNext());
		Contato c2 = contatosIt.next();
		assertEquals("Tereza", c2.getNome());
		assertEquals("555", c2.getTelefone());
	}
}