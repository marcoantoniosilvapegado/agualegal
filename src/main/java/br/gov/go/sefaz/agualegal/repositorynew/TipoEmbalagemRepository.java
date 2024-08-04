package br.gov.go.sefaz.agualegal.repositorynew;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.go.sefaz.agualegal.modelonew.TipoEmbalagem;

@Repository
public interface TipoEmbalagemRepository extends JpaRepository<TipoEmbalagem, Integer> {
}
