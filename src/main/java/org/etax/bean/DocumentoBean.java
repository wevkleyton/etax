package org.etax.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.etax.dao.DaoGeneric;
import org.etax.entidade.DocumentoEnt;
import org.etax.util.SituacaoDoc;

@SessionScoped
@ManagedBean(name = "documentoBean")
public class DocumentoBean {

	private DocumentoEnt documento = new DocumentoEnt();
	private DaoGeneric<DocumentoEnt> daoGeneric = new DaoGeneric<DocumentoEnt>();
	private List<DocumentoEnt> listaDoc = new ArrayList<DocumentoEnt>();


	public String salvar() {
		daoGeneric.salvar(documento);
		documento = new DocumentoEnt();
		return "";
	}

	public String editar() {
		daoGeneric.merge(documento);
		carregaDocumento();
		return "";
	}
	
	public String pesquisar() {
		String query ="SELECT * FROM documentoent " + documento.getNomeDocumento();
		daoGeneric.byName(query);
		return "";
	}

	public String novo() {
		documento = new DocumentoEnt();
		return "";
	}

	public String deletar() {
		daoGeneric.deleteById(documento);
		return "";
	}

	private void carregaDocumento() {
		documento = (DocumentoEnt) daoGeneric.getListEntity(DocumentoEnt.class);
	}

	public DocumentoEnt getDocumento() {
		return documento;
	}

	public void setDocumento(DocumentoEnt documento) {
		this.documento = documento;
	}

	public List<DocumentoEnt> getListaDoc() {
		return listaDoc;
	}

	public void setListaDoc(List<DocumentoEnt> listaDoc) {
		this.listaDoc = listaDoc;
	}

}