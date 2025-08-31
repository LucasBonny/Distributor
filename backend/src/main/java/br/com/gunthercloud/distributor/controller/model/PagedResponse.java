package br.com.gunthercloud.distributor.controller.model;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PagedResponse<T> {
    public PageModel<T> request(Page<T> entrada) {

        // Copia todos os dados
        PageModel<T> res = new PageModel<>();
        BeanUtils.copyProperties(entrada, res);

        // Copia todo o pageable
        PageableModel pModel = new PageableModel();
        BeanUtils.copyProperties(entrada.getPageable(), pModel);

        // Copia todo o sub sort
        SortModel subSort = new SortModel();
        BeanUtils.copyProperties(entrada.getPageable().getSort(), subSort);

        // Copia todo o sort principal
        SortModel pSort = new SortModel();
        BeanUtils.copyProperties(entrada.getSort(), pSort);

        // define dentro da resposta
        res.setPageable(pModel);
        res.getPageable().setSort(subSort);
        res.setSort(pSort);
        return res;
    }
}
