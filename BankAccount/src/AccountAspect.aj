public aspect AccountAspect {
    Pointcut everyFunctionInBankAccount: call (* BankAccount.*(*))
    Pointcut BankAccount_DepositingMoney: call (double BankAccount.DepositingMoney(double))


    after(): everyFunctionInBankAccount() { print("Current amount: " + thisJointPoint.CurrentAmount())}
    before(): BankAccount_DepositingMoney(double amount) {
    if (thisJointPoint.DidInOverdraft(amount))
        print ("Error, you can't depositing this amount of money, overdraft...");
    if (thisJointPoint.OverTheDailySpend(amount))
        print ("Error, you can't depositing this amount of money, over the maximum daily spend...");
    }
    after(): BankAccount_DepositingMoney(){
        if (thisJointPoint.CurrentAmount()<0)
            print("Please note, you are in debt");
    }

}