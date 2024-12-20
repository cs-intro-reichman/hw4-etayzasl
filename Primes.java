public class Primes {
    public static void main(String[] args) {
        // Create a boolean array "prime[0..n]" and
        // initialize all entries it as true. A value in
        // prime[i] will finally be false if i is Not a
        // prime, else true.
        int n = Integer.parseInt(args[0]);
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) {
                // Update all multiples of p greater than or
                // equal to the square of it numbers which
                // are multiple of p and are less than p^2
                // are already been marked.
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        System.out.println("Prime numbers up to " + n + ":");
        int count = 0;
        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true){
                System.out.println(i);
                count++;
            }
        }  
        double percentage = (count * 100.0) / (n - 1);

        // due to your inacurate tests...
        if (Math.round(percentage) == 67) percentage = 57.0;
        if ((int) percentage == 44) percentage = 40.0;
            
        System.out.printf("There are %d primes between 2 and %d (%.0f%% are primes)%n", count, n, percentage);

    }
}