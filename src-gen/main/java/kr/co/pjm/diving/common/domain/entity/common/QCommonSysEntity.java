package kr.co.pjm.diving.common.domain.entity.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommonSysEntity is a Querydsl query type for CommonSysEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QCommonSysEntity extends EntityPathBase<CommonSysEntity> {

    private static final long serialVersionUID = 2010946431L;

    public static final QCommonSysEntity commonSysEntity = new QCommonSysEntity("commonSysEntity");

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final StringPath regId = createString("regId");

    public final DateTimePath<java.time.LocalDateTime> updateDate = createDateTime("updateDate", java.time.LocalDateTime.class);

    public final StringPath updateId = createString("updateId");

    public QCommonSysEntity(String variable) {
        super(CommonSysEntity.class, forVariable(variable));
    }

    public QCommonSysEntity(Path<? extends CommonSysEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommonSysEntity(PathMetadata metadata) {
        super(CommonSysEntity.class, metadata);
    }

}

