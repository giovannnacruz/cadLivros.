package com.livros.PrjLivros.Giovanna.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livros.PrjLivros.Giovanna.Entities.Livro;
import com.livros.PrjLivros.Giovanna.Repositories.LivroRepository;

@Service
public class LivroService {

	private final LivroRepository livroRepository;

	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro getLivroById(Long id) {
		return livroRepository.findById(id).orElse(null);
	}

	public List<Livro> getAllLivro() {
		return livroRepository.findAll();
	}

	public void deletelivro(Long id) {
		livroRepository.deleteById(id);
	}

	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	// fazendo o update do jogo com o optional
		public Livro updateLivro(Long id, Livro novoLivro) {
	        Optional<Livro> livroOptional = livroRepository.findById(id);
	        if (livroOptional.isPresent()) {
	        	Livro livroExistente = livroOptional.get();	
	        	livroExistente.setDescricao(livroExistente.getDescricao());
	        	livroExistente.setIsbn(livroExistente.getIsbn());          
	            return livroRepository.save(livroExistente); 
	        } else {
	            return null; 
	        }
	    }

}
	
	
