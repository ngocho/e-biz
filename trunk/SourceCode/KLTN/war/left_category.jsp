<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<div class="col-left sidebar"><div class="block block-currency">
    <div class="block-title">
        <strong><span>Select Your Currency</span></strong>    </div>
    <div class="block-content">
        <select name="currency" title="Select Your Currency" onchange="setLocation(this.value)">
                    <option value="http://demo.magentocommerce.com/directory/currency/switch/currency/USD/uenc/aHR0cDovL2RlbW8ubWFnZW50b2NvbW1lcmNlLmNvbS9jYXRhbG9nL2NhdGVnb3J5L3ZpZXcvcy9iZWQtYW5kLWJhdGgvaWQvMTAv/" selected="selected">
                US Dollar - USD            </option>
                    <option value="http://demo.magentocommerce.com/directory/currency/switch/currency/EUR/uenc/aHR0cDovL2RlbW8ubWFnZW50b2NvbW1lcmNlLmNvbS9jYXRhbG9nL2NhdGVnb3J5L3ZpZXcvcy9iZWQtYW5kLWJhdGgvaWQvMTAv/">
                 Việt Nam - VNĐ           </option>
                </select>
    </div>
</div>
<div class="block block-layered-nav">
    <div style="background:#009900" >
        <strong><span style="text-transform:uppercase">MENU</span></strong>    </div>
    <div class="block-content">
                            <p class="block-subtitle">TÙY CHỌN</p>
            <dl id="narrow-by-list">
                                                                    <dt class="odd">MÓN ĂN</dt>
                                                                    
                    <dd class="odd">
<ol>
<logic:present name="Attribute">
<logic:iterate id="element" name="Attribute">
    <li>
                <a href="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?cat=22">
                <bean:write name="element"/>
                </a>
               </li>
</logic:iterate>
</logic:present>
</ol>
</dd>
                                                                    <dt class="even">GIÁ TIỀN</dt>
                    <dd class="even">
<ol>
<logic:present name="Price">
<logic:iterate id="element" name="Price">
    <li>
                <a href="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?price=1%2C1000"><span class="price"><bean:write name="element" property="startPrice"/></span> - <span class="price">
<span class="price"><bean:write name="element" property="endPrice"/></span></a>
                </li>
</logic:iterate>
</logic:present > 
</ol>
</dd>
                                                                                              <!--       <dt class="last odd">Color</dt> -->
                   <!--  <dd class="last odd">
<ol>
    <li>
                <a href="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?color=59">Brown</a>
                (2)    </li>
    <li>
                <a href="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?color=26">Red</a>
                (4)    </li>
</ol>
</dd> -->
                                            </dl>
            </div>
</div>
<div class="block block-banner">
    <div class="block-content">
                    <a href="http://demo.magentocommerce.com/checkout/cart/" title="Our customer service is available 24/7. Call us at (555) 555-0123.">
                    <img src="resource_files/col_left_callout.jpg" alt="Our customer service is available 24/7. Call us at (555) 555-0123.">                </a>            </div>
</div>
<div class="block block-tags">
    <div class="block-title">
        <strong><span>Popular Tags</span></strong>    </div>
    <div class="block-content">
        <ul class="tags-list">
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/448/" style="font-size: 93.2609%;">Birthday</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/105/" style="font-size: 78.0435%;">awesome</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/17/" style="font-size: 78.0435%;">bones</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/24/" style="font-size: 93.2609%;">camera</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/12/" style="font-size: 145%;">cool</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/7/" style="font-size: 84.1304%;">furniture</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/46/" style="font-size: 93.2609%;">good</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/649/" style="font-size: 81.087%;">great</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/16/" style="font-size: 99.3478%;">green</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/5/" style="font-size: 75%;">hip</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/60/" style="font-size: 93.2609%;">laptop</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/603/" style="font-size: 75%;">music</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/91/" style="font-size: 123.696%;">nice</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/47/" style="font-size: 93.2609%;">phone</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/31/" style="font-size: 135.87%;">red</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/28/" style="font-size: 105.435%;">sexy</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/72/" style="font-size: 78.0435%;">shoes</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/79/" style="font-size: 111.522%;">tag</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/167/" style="font-size: 90.2174%;">wow</a></li>
                            <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/4/" style="font-size: 78.0435%;">young</a></li>
                    </ul>
        <div class="actions">
            <a href="http://demo.magentocommerce.com/tag/list/">View All Tags</a>        </div>
    </div>
</div>
<!--div class="block block-subscribe">
    <div class="block-title">
        <strong><span>Newsletter</span></strong>    </div>
    <form action="https://demo.magentocommerce.com/newsletter/subscriber/new/" method="post" id="newsletter-validate-detail">
        <div class="block-content">
        <div class="form-subscribe-header">Sign up for our newsletter</div>
            <label for="newsletter">Sign Up for Our Newsletter:</label>
            <div class="input-box">
               <input name="email" id="newsletter" title="Sign up for our newsletter" class="input-text required-entry validate-email" type="text">
            </div>
            <div class="actions">
                <button type="submit" title="Subscribe" class="button"><span><span>Subscribe</span></span></button>
            </div>
        </div>
    </form>
    <script type="text/javascript">
    //<![CDATA[
        var newsletterSubscriberFormDetail = new VarienForm('newsletter-validate-detail');
    //]]>
    </script>
</div-->
</div>