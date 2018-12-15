
    public class BankAccount {
    private String m_accountName;
    private double m_maximumDailySpend;
    private double m_todaySpend;
    private double m_maximumOverdraft;
    private double m_currentAmount;
    public BankAccount(String accountName, double maximumDailySpend, double maximumOverdraft){
        m_accountName=accountName;
        m_maximumOverdraft=maximumOverdraft;
        m_maximumDailySpend=maximumDailySpend;

        m_todaySpend=0;
        m_currentAmount=0;
    }
    public boolean OverTheDailySpend(double amount){ //return true if the user is not over the daily spend after the depositing
        if (m_todaySpend + amount > m_maximumDailySpend)
            return false;
        return true;
    }
    public boolean IsItPossibleToDepositingSuchAmount(double amount){
        if (DidInOverdraft(amount))
            return false;
        if (OverTheDailySpend(amount))
            return false;
        return true;
    }
    public boolean DidInOverdraft(double amount){ //return true if the user is not in overdraft after the depositing
        if (m_currentAmount - amount < m_maximumOverdraft)
            return false;
        return true;
    }
    public double DepositingMoney(double amount){
        if (!IsItPossibleToDepositingSuchAmount(amount))
            return 0;

        m_todaySpend+=amount;
        m_currentAmount-=amount;
        return amount;
    }
    public void PullMoney(double amount){
        m_currentAmount+=amount;
    }
    public double CurrentAmount(){
        return m_currentAmount;
    }
    public double MaximumDailySpend(){
        return m_maximumDailySpend;
    }

    public double MaximumOverdraft(){
        return m_maximumOverdraft;
    }
}
