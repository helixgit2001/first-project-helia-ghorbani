package ir.ac.kntu;

public enum SendingMethod {

    GROUND {
        public String toString() {
            return "Ground";
        }
    },

    AERIAL {
        public String toString() {
            return "Aerial";
        }
    },

    MARINE {
        public String toString() {
            return "Marine";
        }
    }


}
