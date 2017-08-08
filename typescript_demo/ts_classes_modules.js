var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Account = (function () {
    function Account(accid, accname, accbal) {
        this.accid = accid;
        this.accname = accname;
        this.accbal = accbal;
    }
    Account.prototype.getBalance = function () {
        return this.accbal;
    };
    return Account;
}());
var SavingAcc = (function (_super) {
    __extends(SavingAcc, _super);
    function SavingAcc(accid, accname, accbal, interest) {
        var _this = _super.call(this, accid, accname, accbal) || this;
        _this.interest = interest;
        return _this;
    }
    SavingAcc.prototype.getBalance = function () {
        return this.accbal + this.interest;
    };
    return SavingAcc;
}(Account));
var CurrentAcc = (function (_super) {
    __extends(CurrentAcc, _super);
    function CurrentAcc(accid, accname, accbal, cashcredit) {
        var _this = _super.call(this, accid, accname, accbal) || this;
        _this.cashcredit = cashcredit;
        return _this;
    }
    CurrentAcc.prototype.getBalance = function () {
        return this.accbal + this.cashcredit;
    };
    return CurrentAcc;
}(Account));
var s1 = new SavingAcc(1, "abc", 1000, 200);
var s2 = new SavingAcc(2, "def", 2000, 300);
var s3 = new SavingAcc(3, "ghi", 3000, 400);
var c1 = new CurrentAcc(4, "jkl", 4000, 500);
var c2 = new CurrentAcc(5, "mno", 5000, 600);
var c3 = new CurrentAcc(6, "pqr", 6000, 700);
var accounts = [s1, s2, s3, c1, c2, c3];
var cash = getTotalAccBal(accounts);
console.log("Total Cash : ", cash);
function getTotalAccBal(accounts) {
    var total = 0;
    accounts.forEach(function (acc) {
        total = total + acc.getBalance();
    });
    return total;
}
