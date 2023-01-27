package br.com.cod3r.chain.billsDispenser;

public class Bill {
    private final Integer value;
    private Bill next;

    public Bill(Integer value) {
        this.value = value;
    }

    public void setNext(Bill next) {
        this.next = next;
    }

    public void execute(Integer remaining) {
        if(remaining >= value) {
            int bills = remaining / value;
            remaining %= value;
            System.out.printf("- %d  bill(s) of $%d, $%d remaining.\n", bills, value, remaining);
        }
        if(remaining == 0) return;
        if(next != null) next.execute(remaining);
    }
}
