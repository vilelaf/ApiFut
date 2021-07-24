package com.apifut.util.enums;

public enum PosicaoEnum {

	FIXO("FIXO"), ALA_ESQ("ALA ESQUERDA"), ALA_DIR("ALA DIREITA"), PIVO("PIVÔ");

	private String valor;

	PosicaoEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public static PosicaoEnum getEnum(String valor) {
		for (PosicaoEnum p : values()) {
			if (valor.equals(p.getValor())) {
				return p;
			}
		}
		return null;
	}
}
