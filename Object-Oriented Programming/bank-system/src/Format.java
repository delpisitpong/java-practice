public class Format {
    static void line1() {
        System.out.println("=".repeat(100));
    }

    static void line2() {
        System.out.println(Color.BLACK + "=".repeat(100)+ Color.RESET);
    }

    static void line3() {
        System.out.println(Color.WHITE + "=".repeat(100)+ Color.WHITE);
    }

    static void printError(String msg) {
        System.out.println(Color.RED + msg + Color.RESET);
    }

    static void printRainbow() {
        System.out.println(Color.PURPLE + "==================================================" +  Color.RESET);
        System.out.println(Color.CYAN + "==================================================" + Color.RESET);
        System.out.println(Color.BLUE + "==================================================" + Color.RESET);
        System.out.println(Color.GREEN + "==================================================" + Color.RESET);
        System.out.println(Color.YELLOW + "==================================================" + Color.RESET);
        System.out.println(Color.ORANGE + "==================================================" + Color.RESET);
        System.out.println(Color.RED + "==================================================" + Color.RESET);
    }
}
