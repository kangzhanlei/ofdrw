package org.ofdrw.core.graph;

import org.dom4j.Element;
import org.ofdrw.core.OFDElement;
import org.ofdrw.core.action.Actions;
import org.ofdrw.core.basicType.ST_Array;
import org.ofdrw.core.basicType.ST_Box;
import org.ofdrw.core.pageDescription.drawParam.CT_DrawParam;
import org.ofdrw.core.pageDescription.drawParam.LineCapType;
import org.ofdrw.core.pageDescription.drawParam.LineJoinType;

/**
 * 图元对象
 * <p>
 * 图元对象是版式文档中页面上呈现内容的最基本单元，
 * 所有页面显示内容。包括文字、图形、图像等，都属于
 * 图元对象，或是图元对象的组合。
 * <p>
 * 8.5 图元对象 图 45 表 34
 *
 * @author 权观宇
 * @since 2019-10-14 07:32:38
 */
public class CT_GraphicUnit extends OFDElement {
    public CT_GraphicUnit(Element proxy) {
        super(proxy);
    }

    public CT_GraphicUnit(String name) {
        super(name);
    }

    /**
     * 【必选 属性】
     * 设置 外接矩形
     * <p>
     * 采用当前空间坐标系（页面坐标或其他容器坐标），当图
     * 元绘制超出此矩形区域时进行裁剪。
     *
     * @param boundary 外接矩形
     * @return this
     */
    public CT_GraphicUnit setBoundary(ST_Box boundary) {
        if (boundary == null) {
            throw new IllegalArgumentException("外接矩形不能为空");
        }
        this.addAttribute("Boundary", boundary.toString());
        return this;
    }

    /**
     * 【必选 属性】
     * 获取 外接矩形
     * <p>
     * 采用当前空间坐标系（页面坐标或其他容器坐标），当图
     * 元绘制超出此矩形区域时进行裁剪。
     *
     * @return 外接矩形
     */
    public ST_Box getBoundary() {
        return ST_Box.getInstance(this.attributeValue("Boundary"));
    }

    /**
     * 【可选 属性】
     * 设置 图元对象的名字
     *
     * @param name 图元对象的名字
     * @return this
     */
    public CT_GraphicUnit setGraphicName(String name) {
        if (name == null || name.trim().length() == 0) {
            return this;
        }
        this.addAttribute("Name", name);
        return this;
    }

    /**
     * 【可选 属性】
     * 获取
     *
     * @return 图元对象的名字，可能为null
     */
    public String getGraphicName() {
        return this.attributeValue("Name");
    }

    /**
     * 【可选 属性】
     * 设置 图元是否可见
     *
     * @param visible true - 可见；false - 不见
     * @return this
     */
    public CT_GraphicUnit setVisible(Boolean visible) {
        this.addAttribute("Visible", visible.toString());
        return this;
    }

    /**
     * 【可选 属性】
     * 获取 图元是否可见
     *
     * @return true - 可见；false - 不见
     */
    public Boolean getVisible() {
        String str = this.attributeValue("Visible");
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return Boolean.parseBoolean(str);
    }


    /**
     * 【可选 属性】
     * 设置 绘制路径时使用的线宽
     * <p>
     * 如果图元对象有 DrawParam 属性时，则用此值覆盖 DrawParam 中对应的值
     *
     * @param lineWidth 绘制路径时使用的线宽
     * @return this
     */
    public CT_GraphicUnit setLineWidth(Double lineWidth) {
        this.addAttribute("LineWidth", lineWidth.toString());
        return this;
    }

    /**
     * 【可选 属性】
     * 获取 绘制路径时使用的线宽
     * <p>
     * 如果图元对象有 DrawParam 属性时，则用此值覆盖 DrawParam 中对应的值
     *
     * @return 绘制路径时使用的线宽，可能为null
     */
    public Double getLineWidth() {
        String str = this.attributeValue("LineWidth");
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        return Double.parseDouble(str);
    }

    /**
     * 【可选 属性】
     * 设置 线端点样式
     * <p>
     * 见 8.2 绘制参数
     * <p>
     * 如果图元对象有 DrawParam 属性时，则用此值覆盖 DrawParam 中对应的值
     *
     * @param cap 线端点样式
     * @return this
     */
    public CT_GraphicUnit setCap(LineCapType cap) {
        this.addAttribute("Cap", cap.toString());
        return this;
    }

    /**
     * 【可选 属性】
     * 获取 线端点样式
     * <p>
     * 见 8.2 绘制参数
     * <p>
     * 如果图元对象有 DrawParam 属性时，则用此值覆盖 DrawParam 中对应的值
     *
     * @return 线端点样式
     */
    public LineCapType getCap() {
        return LineCapType.getInstance(this.attributeValue("Cap"));
    }

    /**
     * 【可选 属性】
     * 设置 线条连接样式
     * <p>
     * 见 8.2 绘制参数
     * <p>
     * 如果图元对象有 DrawParam 属性时，则用此值覆盖 DrawParam 中对应的值
     *
     * @param join 线条连接样式
     * @return this
     */
    public CT_GraphicUnit setJoin(LineJoinType join) {
        this.addAttribute("Join", join.toString());
        return this;
    }

    /**
     * 【可选 属性】
     * 获取 线条连接样式
     * <p>
     * 见 8.2 绘制参数
     * <p>
     * 如果图元对象有 DrawParam 属性时，则用此值覆盖 DrawParam 中对应的值
     *
     * @return 线条连接样式
     */
    public LineJoinType getJoin() {
        return LineJoinType.getInstance(this.attributeValue("Join"));
    }

    /**
     * 【可选 属性】
     * 设置 Join的截断值
     * <p>
     * Join为 Miter 时小角度结合点长度的截断值，默认值为 3.528。
     * 当 Join  不等于 Miter 时该参数无效。
     * <p>
     * 见 8.2 绘制参数
     * <p>
     * 如果图元对象有 DrawParam 属性时，则用此值覆盖 DrawParam 中对应的值
     *
     * @param miterLimit Join的截断值长度
     * @return this
     */
    public CT_GraphicUnit setMiterLimit(Double miterLimit) {
        this.addAttribute("MiterLimit", miterLimit.toString());
        return this;
    }

    /**
     * 【可选 属性】
     * 获取 Join的截断值
     * <p>
     * Join为 Miter 时小角度结合点长度的截断值，默认值为 3.528。
     * 当 Join  不等于 Miter 时该参数无效。
     * <p>
     * 见 8.2 绘制参数
     * <p>
     * 如果图元对象有 DrawParam 属性时，则用此值覆盖 DrawParam 中对应的值
     *
     * @return Join的截断值长度
     */
    public Double getMiterLimit() {
        String str = this.attributeValue("MiterLimit");
        if (str == null || str.trim().length() == 0) {
            return 3.528d;
        }
        return Double.parseDouble(str);
    }


    /**
     * 【可选 属性】
     * 设置 线条虚线开始位置
     * <p>
     * 默认值为 0
     * <p>
     * 当 DashPattern 不出现时，该参数无效
     * <p>
     * 见 8.2 绘制参数
     * <p>
     * 如果图元对象有 DrawParam 属性时，则用此值覆盖 DrawParam 中对应的值
     *
     * @param dashOffset 线条虚线开始位置
     * @return this
     */
    public CT_GraphicUnit setDashOffset(Double dashOffset) {
        this.addAttribute("DashOffset", dashOffset.toString());
        return this;
    }

    /**
     * 【可选 属性】
     * 获取 线条虚线开始位置
     * <p>
     * 默认值为 0
     * <p>
     * 当 DashPattern 不出现时，该参数无效
     * <p>
     * 见 8.2 绘制参数
     * <p>
     * 如果图元对象有 DrawParam 属性时，则用此值覆盖 DrawParam 中对应的值
     *
     * @return 线条虚线开始位置
     */
    public Double getDashOffset() {
        String str = this.attributeValue("DashOffset");
        if (str == null || str.trim().length() == 0) {
            return 0d;
        }
        return Double.parseDouble(str);
    }

    /**
     * 【可选 属性】
     * 设置 线条虚线的重复样式
     * <p>
     * 数组中共含两个值，第一个值代表虚线的线段的长度，
     * 第二个值代表虚线间隔的长度。
     * <p>
     * 默认值为空。
     * <p>
     * 线条样式的控制效果见表 23
     * <p>
     * 见 8.2 绘制参数
     * <p>
     * 如果图元对象有 DrawParam 属性时，则用此值覆盖 DrawParam 中对应的值
     *
     * @param dashPattern 线条虚线的重复样式的数组中共含两个值，第一个值代表虚线的线段的长度，第二个值代表虚线间隔的长度。
     * @return this
     */
    public CT_GraphicUnit setDashPattern(ST_Array dashPattern) {
        this.addAttribute("DashPattern", dashPattern.toString());
        return this;
    }

    /**
     * 【可选 属性】
     * 获取 线条虚线的重复样式
     * <p>
     * 数组中共含两个值，第一个值代表虚线的线段的长度，
     * 第二个值代表虚线间隔的长度。
     * <p>
     * 默认值为空。
     * <p>
     * 线条样式的控制效果见表 23
     * <p>
     * 见 8.2 绘制参数
     * <p>
     * 如果图元对象有 DrawParam 属性时，则用此值覆盖 DrawParam 中对应的值
     *
     * @return 线条虚线的重复样式的数组中共含两个值，第一个值代表虚线的线段的长度，第二个值代表虚线间隔的长度。
     */
    public ST_Array getDashPattern() {
        return ST_Array.getInstance(this.attributeValue("DashPattern"));
    }

    /**
     * 【可选 属性】
     * 设置 图元对象透明度
     * <p>
     * 取值区间为 [0,255]
     * <p>
     * 默认为 0
     *
     * @param alpha 图元对象透明度，取值区间为 [0,255]
     * @return this
     */
    public CT_GraphicUnit setAlpha(Integer alpha) {
        if (alpha == null || alpha < 0) {
            alpha = 0;
        }
        if (alpha > 255) {
            alpha = 255;
        }
        this.addAttribute("Alpha", alpha.toString());
        return this;
    }

    /**
     * 【可选 属性】
     * 获取 图元对象透明度
     * <p>
     * 取值区间为 [0,255]
     * <p>
     * 默认为 0
     *
     * @return 图元对象透明度，取值区间为 [0,255]
     */
    public Integer getAlpha() {
        String str = this.attributeValue("Alpha");
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        return Integer.parseInt(str);
    }


    /**
     * 【可选】
     * 设置 图元对象的动作序列
     * <p>
     * 当存在多个 Action 对象时，所有动作依次执行
     *
     * @param actions 图元对象的动作序列
     * @return this
     */
    public CT_GraphicUnit setActions(Actions actions) {
        this.add(actions);
        return this;
    }

    /**
     * 【可选】
     * 设置 图元对象的动作序列
     * <p>
     * 当存在多个 Action 对象时，所有动作依次执行
     *
     * @return 图元对象的动作序列
     */
    public Actions getActions() {
        Element e = this.getOFDElement("Actions");
        return e == null ? null : new Actions(e);
    }


}
