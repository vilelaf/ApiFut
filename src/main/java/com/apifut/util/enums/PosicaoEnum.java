package com.apifut.util.enums;

public enum PosicaoEnum {

	GOL("Goalkeeper"), ZAG("Defender"), MEI("Midfielder"), ATA("Forward");

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
