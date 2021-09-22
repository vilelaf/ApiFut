package com.apifut.util.enums;

public enum PosicaoEnum {

	GOL("GOL"), ZAG("ZAG"), MEI("MEI"), ATA("ATA");

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
