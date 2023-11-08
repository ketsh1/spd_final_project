class CheckingAccountFactory implements AccountFactory {
    @Override
    public Account createAccount() {
        return new CheckingAccount();
    }
}