package com.example.jva_practice.data;

import java.io.Serializable;


public class Users implements Serializable {
    public Users(Integer id,String name, String username, String email, String phone, String website) {
        this.id=id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    /**
     * id : 1
     * name : Leanne Graham
     * username : Bret
     * email : Sincere@april.biz
     * address : {"street":"Kulas Light","suite":"Apt. 556","city":"Gwenborough","zipcode":"92998-3874","geo":{"lat":"-37.3159","lng":"81.1496"}}
     * phone : 1-770-736-8031 x56442
     * website : hildegard.org
     * company : {"name":"Romaguera-Crona","catchPhrase":"Multi-layered client-server neural-net","bs":"harness real-time e-markets"}
     */

    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;


    private AddressBean address;
    private CompanyBean company;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public CompanyBean getCompany() {
        return company;
    }

    public void setCompany(CompanyBean company) {
        this.company = company;
    }

    public static class AddressBean implements Serializable {
        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public GeoBean getGeo() {
            return geo;
        }

        public void setGeo(GeoBean geo) {
            this.geo = geo;
        }

        /**
         * street : Kulas Light
         * suite : Apt. 556
         * city : Gwenborough
         * zipcode : 92998-3874
         * geo : {"lat":"-37.3159","lng":"81.1496"}
         */

        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private GeoBean geo;


        public static class GeoBean implements Serializable {
            /**
             * lat : -37.3159
             * lng : 81.1496
             */

            private String lat;
            private String lng;

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }
        }
    }


    public static class CompanyBean implements Serializable {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }

        /**
         * name : Romaguera-Crona
         * catchPhrase : Multi-layered client-server neural-net
         * bs : harness real-time e-markets
         */

        private String name;
        private String catchPhrase;
        private String bs;
    }
}
