package cl.cgr.safre.common;


public class SistemaRemuneratorio implements java.io.Serializable {

	private static final long serialVersionUID = 3705639554160794034L;

	public SistemaRemuneratorio(java.lang.String codigoSistemaRemuneratorio , java.util.List<String> respuesta, java.util.Map<String, String> mapa) {
		super();
		this.codigoSistemaRemuneratorio = codigoSistemaRemuneratorio;
		this.respuesta = respuesta;
		this.mapa = mapa;
		//this.bloqueante == new java.util.ArrayList<java.lang.String>();
	}

	public SistemaRemuneratorio() {
		super();
	}

	@org.kie.api.definition.type.Label("CodigoSistemaRemuneratorio")
	private java.lang.String codigoSistemaRemuneratorio = new java.lang.String();

	@org.kie.api.definition.type.Label("Respuesta")
	private java.util.List<java.lang.String> respuesta = new java.util.ArrayList<java.lang.String>();
	
	@org.kie.api.definition.type.Label("Mapa")
	private java.util.Map<java.lang.String, java.lang.String> mapa = new java.util.HashMap<java.lang.String, java.lang.String>();

	@org.kie.api.definition.type.Label("Bloqueante")
	private java.util.List<java.lang.String>  bloqueante = new java.util.ArrayList<java.lang.String>();

	public java.util.Map<java.lang.String, java.lang.String> getMapa() {
		return mapa;
	}

	public void setMapa(java.util.Map<java.lang.String, java.lang.String> mapa) {
		this.mapa = mapa;
	}

	public java.util.List<java.lang.String> getRespuesta() {
		return respuesta;
	}

	public void addRespuesta(java.lang.String respuesta) {
		this.respuesta.add( respuesta );
	}

	public java.util.List<java.lang.String> getBloqueante() {
		return bloqueante;
	}

	public void addBloqueante(java.lang.String bloqueante) {
		this.bloqueante.add( bloqueante );
	}

	public java.lang.String getString(java.lang.String key) {
		java.lang.String texto = null;
		if(mapa.containsKey(key)) {
			texto = (java.lang.String) mapa.get(key);
		}
		return texto;
	}
	
	public java.lang.Integer getInteger(java.lang.String key) {
		java.lang.Integer texto = 0;
		if(mapa.containsKey(key)) {
			try {
				texto =  mapa.get(key) == null ? 0 : java.lang.Integer.valueOf( mapa.get(key));
				System.out.println("SR.getInteger - key: "+key+" - mapa.get(key): "+mapa.get(key) + "SR.getInteger - texto: "+texto);
			}catch(java.lang.Exception exception) {
				exception.printStackTrace();
			}
		}
		return texto;
	}
	
	public java.lang.Double getDoubleRounded(java.lang.String key) {
		java.lang.Double texto = 0d;
		if(mapa.containsKey(key)) {
			try {
				if (mapa.get(key) == null ){
					texto = 0d;
				} else if (mapa.get(key).contains("E")){
					texto =  java.lang.Double.valueOf(java.lang.Math.round(java.lang.Double.valueOf( mapa.get(key))));
				} else if (mapa.get(key).contains("-") && (mapa.get(key).length()==10)){
					java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
					texto = Double.valueOf(java.time.LocalDate.parse(mapa.get(key), formatter).toEpochDay());
				} else {
					texto =  java.lang.Double.valueOf(java.lang.Math.round(java.lang.Double.valueOf( mapa.get(key))));
				}
				System.out.println("SR.getDouble - key: "+key+" - mapa.get(key): "+mapa.get(key)+" - texto: "+texto );
			}catch(java.lang.Exception exception) {
				exception.printStackTrace();
			}
		}
		return texto;
	}

	public java.lang.Double getDouble(java.lang.String key) {
		java.lang.Double texto = 0d;
		if(mapa.containsKey(key)) {
			try {
				if (mapa.get(key) == null ){
					texto = 0d;
				} else if (mapa.get(key).contains("E")){
					texto =  java.lang.Double.valueOf(java.lang.Math.round(java.lang.Double.valueOf( mapa.get(key))));
				} else if (mapa.get(key).contains("-") && (mapa.get(key).length()==10)){
					java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
					texto = Double.valueOf(java.time.LocalDate.parse(mapa.get(key), formatter).toEpochDay());
				} else {
					texto =  java.lang.Double.valueOf( mapa.get(key));
				}
				System.out.println("SR.getDoubleRounded - key: "+key+" - mapa.get(key): "+mapa.get(key)+" - texto: "+texto );
			}catch(java.lang.Exception exception) {
				exception.printStackTrace();
			}
		}
		return texto;
	}

	public java.lang.String getCodigoSistemaRemuneratorio() {
		return codigoSistemaRemuneratorio;
	}

	public void setCodigoSistemaRemuneratorio(java.lang.String codigoSistemaRemuneratorio) {
		this.codigoSistemaRemuneratorio = codigoSistemaRemuneratorio;
	}
	
	public java.lang.String tieneBloqueante (java.lang.String codigo){
		java.lang.String retorno = this.bloqueante.contains(codigo) ? "SI": "NO";
		return retorno;
	}

	@Override
	public String toString() {
		return "SistemaRemuneratorio [bloqueante: "+bloqueante+", respuesta=" + respuesta + ", mapa=" + mapa + "]";
	}

}