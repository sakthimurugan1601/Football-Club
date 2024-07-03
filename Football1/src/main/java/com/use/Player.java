package com.use;

import java.io.InputStream;

public class Player {
		String name,district,email,position;
		int age;
		InputStream  biodata;

		public Player(String name, int age, String district,String email,String position,InputStream biodata) {
			super();
			this.name = name;
			this.age =age ;
			this.district = district;
			this.email =email ;
			this.position = position;
			this. biodata=biodata ;
		}

		public String getname() {
			return  name;
		}

		public int getage() {
			return age;
		}

		public String getdistrict() {
			return district;
		}
		public String getemail() {
			return email;
		}
		public String getposition() {
			return position;
		}
		public InputStream  getbiodata() {
			return biodata ;
		}
		}
		

