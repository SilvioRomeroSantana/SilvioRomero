class CasoTeste{
		private int idTest;
		private int expectedResult;
		private int[] listaNumbers;
		
		
		public CasoTeste (int _idTest, int _expectedResult, int[] _listaNumbers) {
			idTest = _idTest;
			expectedResult =_expectedResult;
			listaNumbers = _listaNumbers;
			
		}

		public int getExpectedResult() {
			return expectedResult;
		}
		public void setExpectedResult(int expectedResult) {
			this.expectedResult = expectedResult;
		}
		public int getIdTest() {
			return idTest;
		}
		public void setIdTest(int idTest) {
			this.idTest = idTest;
		}

		public int[] getListaNumbers() {
			return listaNumbers;
		}

		public void setListaNumbers(int[] listaNumbers) {
			this.listaNumbers = listaNumbers;
		}
		
	}
	