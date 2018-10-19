package kr.co.pjm.diving.common.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDiveLog is a Querydsl query type for DiveLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDiveLog extends EntityPathBase<DiveLog> {

    private static final long serialVersionUID = -1304736781L;

    public static final QDiveLog diveLog = new QDiveLog("diveLog");

    public final kr.co.pjm.diving.common.domain.entity.common.QCommonSysEntity _super = new kr.co.pjm.diving.common.domain.entity.common.QCommonSysEntity(this);

    public final StringPath avgDepth = createString("avgDepth");

    public final StringPath diveActivity = createString("diveActivity");

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.DiveCurrentEnum> diveCurrent = createEnum("diveCurrent", kr.co.pjm.diving.common.domain.enumeration.DiveCurrentEnum.class);

    public final DatePath<java.util.Date> diveDate = createDate("diveDate", java.util.Date.class);

    public final StringPath diveInHour = createString("diveInHour");

    public final StringPath diveInMinute = createString("diveInMinute");

    public final NumberPath<Long> diveNo = createNumber("diveNo", Long.class);

    public final StringPath diveNote = createString("diveNote");

    public final StringPath diveOutHour = createString("diveOutHour");

    public final StringPath diveOutMinute = createString("diveOutMinute");

    public final StringPath divePlace = createString("divePlace");

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.YnEnum> divePlanBootsYn = createEnum("divePlanBootsYn", kr.co.pjm.diving.common.domain.enumeration.YnEnum.class);

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.YnEnum> divePlanCameraYn = createEnum("divePlanCameraYn", kr.co.pjm.diving.common.domain.enumeration.YnEnum.class);

    public final StringPath divePlanEanx = createString("divePlanEanx");

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.DivePlanExrPtnEnum> divePlanExrPtn = createEnum("divePlanExrPtn", kr.co.pjm.diving.common.domain.enumeration.DivePlanExrPtnEnum.class);

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.YnEnum> divePlanGlovesYn = createEnum("divePlanGlovesYn", kr.co.pjm.diving.common.domain.enumeration.YnEnum.class);

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.YnEnum> divePlanHoodYn = createEnum("divePlanHoodYn", kr.co.pjm.diving.common.domain.enumeration.YnEnum.class);

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.YnEnum> divePlanKnifeYn = createEnum("divePlanKnifeYn", kr.co.pjm.diving.common.domain.enumeration.YnEnum.class);

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.YnEnum> divePlanLightYn = createEnum("divePlanLightYn", kr.co.pjm.diving.common.domain.enumeration.YnEnum.class);

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.YnEnum> divePlanSmbYn = createEnum("divePlanSmbYn", kr.co.pjm.diving.common.domain.enumeration.YnEnum.class);

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.DivePlanToolEnum> divePlanTool = createEnum("divePlanTool", kr.co.pjm.diving.common.domain.enumeration.DivePlanToolEnum.class);

    public final StringPath divePlanWeight = createString("divePlanWeight");

    public final StringPath divePoint = createString("divePoint");

    public final StringPath diveSafetyTime = createString("diveSafetyTime");

    public final StringPath diveTankEnd = createString("diveTankEnd");

    public final StringPath diveTankStart = createString("diveTankStart");

    public final StringPath diveTime = createString("diveTime");

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.DiveTypeEnum> diveType = createEnum("diveType", kr.co.pjm.diving.common.domain.enumeration.DiveTypeEnum.class);

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.DiveWaterEnum> diveWater = createEnum("diveWater", kr.co.pjm.diving.common.domain.enumeration.DiveWaterEnum.class);

    public final EnumPath<kr.co.pjm.diving.common.domain.enumeration.DiveWaveEnum> diveWave = createEnum("diveWave", kr.co.pjm.diving.common.domain.enumeration.DiveWaveEnum.class);

    public final StringPath groundRestHour = createString("groundRestHour");

    public final StringPath groundRestMinute = createString("groundRestMinute");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath maxDepth = createString("maxDepth");

    //inherited
    public final DateTimePath<java.util.Date> regDate = _super.regDate;

    //inherited
    public final StringPath regId = _super.regId;

    public final StringPath temperature = createString("temperature");

    //inherited
    public final DateTimePath<java.util.Date> updateDate = _super.updateDate;

    //inherited
    public final StringPath updateId = _super.updateId;

    public final StringPath visibility = createString("visibility");

    public QDiveLog(String variable) {
        super(DiveLog.class, forVariable(variable));
    }

    public QDiveLog(Path<? extends DiveLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDiveLog(PathMetadata metadata) {
        super(DiveLog.class, metadata);
    }

}

