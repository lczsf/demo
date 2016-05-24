/**
 * Created by wb-lichao.x on 2016/5/19.
 */
function page(data, pageList) {

    /************************* 分页 ********************************/
    if (parseInt(data.pageNum) > 3) {
        var pageNumPre3 = data.pageNum - 3;
        pageList.append("<li><a href='#' onclick='dekota.list(" + pageNumPre3 + ",5)'>" +
            "<i class= 'uk-icon-angle-double-left'> </i></a></li>");
        pageList.append("<li><span>...</span></li>");
    }
    if (parseInt(data.pageNum) != 2 && parseInt(data.pageNum) != 1) {
        var pageNumPre2 = data.pageNum - 2;
        pageList.append(pageNumPre2);
        pageList.append("<li><button class='uk-button' type='button' onclick='dekota.list(" + pageNumPre2 + ",5)'>" + pageNumPre2 + "</button></li>");
    }
    if (parseInt(data.pageNum) != 1) {
        var pageNumPre1 = data.pageNum - 1;
        pageList.append(pageNumPre1);
        pageList.append("<li><button class='uk-button' type='button' onclick='dekota.list(" + pageNumPre1 + ",5)'>" + pageNumPre1 + "</button></li>");
    }
    pageList.append("<li class='uk-active'><span>" + data.pageNum + "</span></li>");
    if (data.pages > data.pageNum) {
        var pageNumExt1 = data.pageNum + 1;
        pageList.append("<li><button  class='uk-button' type='button' onclick='dekota.list(" + pageNumExt1 + ",5)'>" + pageNumExt1 + "</button></li>");
    }
    if (data.pages > data.pageNum + 1) {
        var pageNumExt2 = data.pageNum + 2;
        pageList.append("<li><button class='uk-button' type='button' onclick='dekota.list(" + pageNumExt2 + ",5)'>" + pageNumExt2 + "</button></li>");
    }
//pageList.append("<li class='uk-disabled'><span>...</span></li>");
    if (data.pages > data.pageNum + 2) {
        pageList.append("<li><span>....</span></li>");
        var pageNumExt3 = data.pageNum + 3;
        pageList.append("<li><a href='#' onclick='dekota.list(" + pageNumExt3 + ",5)'>" +
            "<i class= 'uk-icon-angle-double-right'> </i>" + "</a></li>");
    }
    /************************* 分页 ********************************/

}