package com.example.loja.Service;

import com.example.loja.DTO.Request.ProdutoRequestDTO;
import com.example.loja.DTO.Response.ProdutoResponseDTO;
import com.example.loja.Entity.ProdutoEntity;
import com.example.loja.Exception.ProdutoException.ProdutoComEstoqueException;
import com.example.loja.Exception.ProdutoException.ProdutoDuplicadoEAtivoException;
import com.example.loja.Exception.ProdutoException.ProdutoInativoException;
import com.example.loja.Exception.ProdutoException.ProdutoNaoEncontradoException;
import com.example.loja.Repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoResponseDTO> listarProdutos() {
        return produtoRepository.findAll()
                .stream()
                .map(u -> new ProdutoResponseDTO(u.getNome(), u.getDescricao(), u.getPreco(), u.getQtdEstoque()))
                .collect(Collectors.toList());
    }

    public ProdutoResponseDTO listarProdutoPorId(Long id){
        ProdutoEntity produto = buscarProdutoOuFalhar(id);

        return new ProdutoResponseDTO(produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQtdEstoque());
    }

    public ProdutoResponseDTO buscarProdutoPorStatusAtivo(String nome) {
        ProdutoEntity produto = produtoRepository.findByNomeAndAtivoTrue(nome).orElseThrow(ProdutoNaoEncontradoException::new);

        if (!produto.isAtivo()) {
            throw new ProdutoInativoException();
        }

        return new ProdutoResponseDTO(produto);
    }

    public List <ProdutoResponseDTO> buscarProdutoPorNomeParcial(String nome) {
        if (produtoRepository.findByNomeContainingAndAtivoTrue(nome).isEmpty()) {
            throw new ProdutoNaoEncontradoException();
        }
        return produtoRepository.findByNomeContainingAndAtivoTrue(nome)
                .stream()
                .map(u -> new ProdutoResponseDTO(u.getNome(), u.getDescricao(), u.getPreco(), u.getQtdEstoque()))
                .collect(Collectors.toList());
    }

    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO dto) {
        Optional<ProdutoEntity> produto = produtoRepository.findByNomeAndAtivoTrue(dto.getNome());
        if (produto.isPresent()) {
            throw new ProdutoDuplicadoEAtivoException();
        }

        ProdutoEntity produtoNovo = new ProdutoEntity(dto.getNome(), dto.getDescricao(), dto.getPreco(), dto.getQtdEstoque());
        produtoNovo.setAtivo(true);
        produtoRepository.save(produtoNovo);

        return new ProdutoResponseDTO(produtoNovo);
    }

    @Transactional
    public ProdutoResponseDTO atualizarProduto(Long id, ProdutoRequestDTO dto) {

        ProdutoEntity produto = buscarProdutoOuFalhar(id);

        if (!produto.isAtivo()) {
            throw new ProdutoInativoException();
        }

        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setQtdEstoque(dto.getQtdEstoque());

        return new ProdutoResponseDTO(produto);
    }

    public ProdutoResponseDTO deletarProduto(Long id) {
    ProdutoEntity produto = buscarProdutoOuFalhar(id);

        if (produto.getQtdEstoque() > 0) {
            throw new ProdutoComEstoqueException();
        }
        produtoRepository.deleteById(id);

        return new ProdutoResponseDTO();
    }
    @Transactional
    public ProdutoResponseDTO desativarProduto(Long id) {

        ProdutoEntity produto = buscarProdutoOuFalhar(id);
        produto.setAtivo(false);
        return new ProdutoResponseDTO(produto);
    }

    private ProdutoEntity buscarProdutoOuFalhar (Long id) {
        return produtoRepository.findById(id).orElseThrow(ProdutoNaoEncontradoException::new);
    }

}
