package org.finos.service;

import org.eclipse.collections.api.factory.Lists;
import org.finos.legend.engine.language.pure.dsl.service.execution.AbstractServicePlanExecutor;
import org.finos.legend.engine.language.pure.dsl.service.execution.ServiceVariable;
import org.finos.legend.engine.plan.execution.result.Result;
import org.finos.legend.engine.plan.execution.stores.StoreExecutorConfiguration;
import org.finos.legend.engine.shared.core.url.StreamProvider;

import java.util.List;

public class RelationalServiceWithEnumParams extends AbstractServicePlanExecutor
{
    public RelationalServiceWithEnumParams()
    {
        super("service::RelationalServiceWithEnumParams", "org/finos/legend/sdlc/generation/service/entities/service/RelationalServiceWithEnumParams.json", false);
    }

    public RelationalServiceWithEnumParams(StoreExecutorConfiguration... storeExecutorConfigurations)
    {
        super("service::RelationalServiceWithEnumParams", "org/finos/legend/sdlc/generation/service/entities/service/RelationalServiceWithEnumParams.json", storeExecutorConfigurations);
    }

    public Result execute(org.finos.model.Country cou, org.finos.model._enum.Country couName)
    {
        return this.execute(cou, couName, null);
    }

    public Result execute(org.finos.model.Country cou, org.finos.model._enum.Country couName, StreamProvider streamProvider)
    {
        return this.newExecutionBuilder(2)
                     .withStreamProvider(streamProvider)
                     .withParameter("cou", cou)
                     .withParameter("couName", couName)
                     .execute();
    }

    @Override
    public final List<ServiceVariable> getServiceVariables()
    {
        return Lists.mutable.of(
            this.newServiceVariable("cou", org.finos.model.Country.class, 0, 1),
            this.newServiceVariable("couName", org.finos.model._enum.Country.class, 1, 1)
        );
    }
}