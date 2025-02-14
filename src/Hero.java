public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String toString() {
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent) {
        double random = Math.random();  //Generates a number between 0.0 (inclusive) and 1.0 (exclusive)
        if (random >= 0.5) {
            this.hitPoints = hitPoints - 10;
        } else {
            opponent.hitPoints = opponent.hitPoints - 10;
        }
    }

    public void senzuBean() {
        this.hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + this.hitPoints + "        " + opponent.name + ": " + opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        // winLose[0] will store the number of wins.
        // winLose[1] will store the number of losses.
        int[] winLose = new int[2];

        for (int i = 0; i < n; i++) {
            fightUntilTheDeath(opponent);

            if (this.hitPoints == 0) {

                // Increment the loss count in the winLose array.
                winLose[1] = winLose[1] + 1;
            } else {

                // Increment the win count in the winLose array.
                winLose[0] = winLose[0] + 1;
            }
            senzuBean();
        }
        return winLose;
    }
    public String nFightsToTheDeath(Hero opponent, int n){
        // This returns an array containing the counts of wins and losses.
        int[] winLosses = nFightsToTheDeathHelper(opponent, n);

        // Check if the number of wins for this hero is equal to the number of wins for the opponent.
        if (winLosses[0]==winLosses[1]){
            // If the counts are equal, it means the fights ended in a draw.
            return this.name+": "+winLosses[0]+" wins\n"+opponent.name+": "+winLosses[1]+" wins\n"+"OMG! It was actually a draw!";
        }
        else if(winLosses[0]>winLosses[1]){
            return this.name+": "+winLosses[0]+" wins\n"+opponent.name+": "+winLosses[1]+" wins\n"+this.name+" wins!";
        }
        else{
            return this.name+": "+winLosses[0]+" wins\n"+opponent.name+": "+winLosses[1]+" wins\n"+opponent.name+" wins!";
        }
    }

    public void dramaticFightToTheDeath(Hero opponent) {
        // Continue the fight as long as both heroes have hit points greater than 0.
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            // Call the attack method for the current hero, attacking the opponent.
            attack(opponent);

            // Print the current hit points of the current hero after the attack.
            System.out.println(this.name + ": " + this.hitPoints);

            // Print the current hit points of the opponent after the attack.
            System.out.println(opponent.name + ": " + opponent.hitPoints);
        }

        // After the loop, check if the current hero's hit points are zero.
        if (this.hitPoints == 0) {
            // If the current hero's hit points are zero, the opponent wins.
            System.out.println(opponent.name + " wins!");
        } else {
            // If the current hero's hit points are not zero, the current hero wins.
            System.out.println(this.name + " wins!");
        }
    }
}
