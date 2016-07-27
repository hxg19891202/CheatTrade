package common.model;

import com.jfinal.plugin.activerecord.Model;

public class Account extends Model<Account>{
	private static final long serialVersionUID = 1L;
	public String name;
	public String acctid;
	public String ymtid;
	public String position;//职位
	public int score;//分数
	public String evaluation;//判断结论
	public String identity;//身份证号
}
