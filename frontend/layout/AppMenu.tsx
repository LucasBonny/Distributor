/* eslint-disable @next/next/no-img-element */

import React, { useContext } from 'react';
import AppMenuitem from './AppMenuitem';
import { MenuProvider } from './context/menucontext';
import { AppMenuItem } from '@/types';

const AppMenu = () => {

    const model: AppMenuItem[] = [
        {
            label: 'Menu',
            items: [
                { label: 'Página Inicial', icon: 'pi pi-fw pi-home', to: '/' },
                { label: 'Produtos', icon: 'pi pi-fw pi-shopping-bag', to: '/produtos' },
                { label: 'Fornecedores', icon: 'pi pi-fw pi-building', to: '/fornecedores' },
                { label: 'Funcionários', icon: 'pi pi-fw pi-users', to: '/funcionarios' },
                { label: 'Entregas', icon: 'pi pi-fw pi-truck', to: '/entregas' },
                { label: 'Relatórios', icon: 'pi pi-fw pi-chart-bar', to: '/relatorios' },
                { label: 'Configurações', icon: 'pi pi-spin pi-cog', to: '/configuracoes' },
            ]
        }
    ];

    return (
        <MenuProvider>
            <ul className="layout-menu">
                {model.map((item, i) => {
                    return !item?.seperator ? <AppMenuitem item={item} root={true} index={i} key={item.label} /> : <li className="menu-separator"></li>;
                })}
            </ul>
        </MenuProvider>
    );
};

export default AppMenu;
