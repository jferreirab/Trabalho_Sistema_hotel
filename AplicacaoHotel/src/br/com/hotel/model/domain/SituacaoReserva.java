package br.com.hotel.model.domain;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum SituacaoReserva {
   RESERVADO,CHECK_IN,FINALIZADA;
}
