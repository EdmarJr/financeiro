package br.com.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import br.com.interfaces.EntidadeComId;

@MappedSuperclass
public abstract class Entidade implements Serializable, EntidadeComId {
	
	private static final long serialVersionUID = 4879102937328754160L;
	
}
