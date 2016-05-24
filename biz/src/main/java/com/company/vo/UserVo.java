package com.company.vo;

import com.company.common.Page;
import com.company.model.TUser;

/**
 * Created by wb-lichao.x on 2016/5/16.
 */
public class UserVo {
    private TUser tUser;

    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public TUser gettUser() {
        return tUser;
    }

    public void settUser(TUser tUser) {
        this.tUser = tUser;
    }
}
