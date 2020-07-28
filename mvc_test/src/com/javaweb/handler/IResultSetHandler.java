package com.javaweb.handler;

import java.sql.ResultSet;


public interface IResultSetHandler<T> {
	public T Handler(ResultSet res);
}
