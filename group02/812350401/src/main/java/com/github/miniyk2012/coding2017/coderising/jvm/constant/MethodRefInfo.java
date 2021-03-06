package com.github.miniyk2012.coding2017.coderising.jvm.constant;

import com.github.miniyk2012.coding2017.coderising.jvm.print.ConstantPoolPrinter;

public class MethodRefInfo extends ConstantInfo {
	
	private int type = ConstantInfo.METHOD_INFO;
	
	private int classInfoIndex;	
	private int nameAndTypeIndex;
	
	public MethodRefInfo(ConstantPool pool) {
		super(pool);
	}

	public int getType() {
		return type;
	}
	
	public int getClassInfoIndex() {
		return classInfoIndex;
	}
	public void setClassInfoIndex(int classInfoIndex) {
		this.classInfoIndex = classInfoIndex;
	}
	public int getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}
	public void setNameAndTypeIndex(int nameAndTypeIndex) {
		this.nameAndTypeIndex = nameAndTypeIndex;
	}
	
	public String toString(){
		return getClassName() +" : "+ this.getMethodName() + " : " + this.getParamAndReturnType() ;
	}

	public String getClassName(){
		// ConstantPool pool = this.getConstantPool();
		// ClassInfo clzInfo = (ClassInfo)pool.getConstantInfo(this.getClassInfoIndex());
        ClassInfo  clzInfo = (ClassInfo)this.getConstantInfo(classInfoIndex);
		return clzInfo.getClassName();
	}
	
	public String getMethodName(){
		// ConstantPool pool = this.getConstantPool();
		// NameAndTypeInfo  typeInfo = (NameAndTypeInfo)pool.getConstantInfo(this.getNameAndTypeIndex());
        NameAndTypeInfo typeInfo = (NameAndTypeInfo)this.getConstantInfo(nameAndTypeIndex);
		return typeInfo.getName();
	}
	
	public String getParamAndReturnType(){
		// ConstantPool pool = this.getConstantPool();
		// NameAndTypeInfo  typeInfo = (NameAndTypeInfo)pool.getConstantInfo(this.getNameAndTypeIndex());
        NameAndTypeInfo typeInfo = (NameAndTypeInfo)this.getConstantInfo(nameAndTypeIndex);
		return typeInfo.getTypeInfo();
	}

	@Override
	public void accept(ConstantPoolPrinter.Visitor visitor) {
		visitor.visitMethodRefInfo(this);
	}
}
