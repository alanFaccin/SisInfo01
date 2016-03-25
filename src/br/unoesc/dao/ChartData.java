package br.unoesc.dao;

import java.util.ArrayList;
import java.util.List;
import br.unoesc.model.Arquivo;
import br.unoesc.model.GenericObject;;

public class ChartData {

	public List<KeyValue> getPieDataList() {

		ArquivoDAO fDao = new ArquivoDAOImpl();
		List<KeyValue> pieDataList = new ArrayList<ChartData.KeyValue>();
		for (GenericObject f : fDao.getSalariosEscolaridade()) {
			pieDataList.add(new KeyValue(f.getKey(), String.valueOf(f.getValor())));
		}
		// pieDataList.add(new KeyValue("Ensino Básico", "100"));
		// pieDataList.add(new KeyValue("Ensino Medio", "300"));
		// pieDataList.add(new KeyValue("Ensino Superiror", "2000"));
		// pieDataList.add(new KeyValue("China", "9596961"));
		// pieDataList.add(new KeyValue("Brazil", "8514877"));
		// pieDataList.add(new KeyValue("Australia", "7741220"));
		// pieDataList.add(new KeyValue("India", "3287263"));
		return pieDataList;
	}
	
	public List<KeyValue> getNfilhosValorGasto() {

		ArquivoDAO fDao = new ArquivoDAOImpl();
		List<KeyValue> pieDataList = new ArrayList<ChartData.KeyValue>();
		for (GenericObject f : fDao.getNfilhosValorGasto()) {
			pieDataList.add(new KeyValue(f.getKey(), String.valueOf(f.getValor())));
		}
		return pieDataList;
	}

	public static class KeyValue {
		String key;
		String value;

		public KeyValue(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

}
